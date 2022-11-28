/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import clases.Caja;
import clases.ProductoVendido;
import clases.Venta;
import clasesJDBC.CajaJDBC;
import clasesJDBC.ProductoVendidoJDBC;
import clasesJDBC.VentaJDBC;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.jfree.data.time.Day;
import tickets.Impresor;
import tickets.ImprimirVenta;

/**
 *
 * @author fell
 */
public class poolIngresarVenda implements Callable<String>{
   
    private ControladorTiendaPrincipal controladorProductos;
    double precioTotal=0;
    public poolIngresarVenda(ControladorTiendaPrincipal controladorProductos) {
        this.controladorProductos=controladorProductos;
   
    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolIngresoVenta Terminado";
    }
    
    
    public void mostrarHorarios(){
       ProductoVendidoJDBC productoVender= new ProductoVendidoJDBC();
       HashMap<Integer, ProductoVendido> productosVenderResumido= new HashMap<Integer, ProductoVendido>();
  
       

        double precioTotal=Double.valueOf(String.format("%.2f",controladorProductos.getPrecioVoucher()));
       
        for (HashMap.Entry<String, ProductoVendido> entry : controladorProductos.getProductosVender().entrySet()) {
           int idProducto=entry.getValue().getIdProducto();
           ProductoVendido proIngr=new ProductoVendido();
           proIngr=entry.getValue();
           ProductoVendido esta=productosVenderResumido.get(proIngr.getIdProducto());
           if(esta!=null){
              double cantidadAnterior=productosVenderResumido.get(idProducto).getCantidadVendida();
          
              productosVenderResumido.get(idProducto).setCantidadVendida(cantidadAnterior+ proIngr.getCantidadVendida());
           }else{
            
               productosVenderResumido.put(idProducto,proIngr);
           }
        }
       String resultado=productoVender.consultar(productosVenderResumido);
       if(resultado.equals("")){
        VentaJDBC venta= new VentaJDBC();
        CajaJDBC cajaAbierta =new CajaJDBC();
        Caja cajaActual=cajaAbierta.CajasAbiertas();
        Date dato=new Date();
        String idVenta=controladorProductos.getUsuario().getIdUsuario()+"-"+dato.getTime();
        Venta ventaIngresar=new Venta(idVenta,precioTotal,0,cajaActual.getIdCaja(),controladorProductos.getUsuario().getIdUsuario());
        venta.insertarVenta(ventaIngresar);
        double cajaCierre=Double.valueOf(String.format("%.2f",cajaActual.getCierreCaja()+precioTotal));
        
        cajaAbierta.ingresarAumentoPorVenta(cajaCierre,cajaActual.getIdCaja());
        
        productoVender.insertaProductoVendido(productosVenderResumido, idVenta);
        controladorProductos.getProductosVender().clear();
        controladorProductos.proceso("BotonIngresarProducto");
        JOptionPane.showMessageDialog(null, "Venta ingresada");
        int input = JOptionPane.showConfirmDialog(null, "¿Imprimir váucher?");
        // 0=yes, 1=no, 2=cancel
        if(input==0){
            ImprimirVenta imp= new ImprimirVenta();
            String ruta =ImprimirVenta.ingresarDocumentoImprimir(ventaIngresar, productosVenderResumido,controladorProductos.getUsuario());
            Impresor impresor = new Impresor();

            try {
                impresor.imprimir(ruta);
            } catch (PrinterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);

            }    
            
        }

       }else{
        JOptionPane.showMessageDialog(null, resultado);
       }
       //productoVender.insertaProductoVendido(productosVenderResumido);
       
       
    
    }


   
}

