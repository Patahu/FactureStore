/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIingresarProductoFacturaBoleta;

import GUI_Tienda.principal.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.ProductoJDBC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class poolRecalcularProductoIngresar implements Callable<String>,ActionListener{

   private ControladorFacturaBoleta controladorFacturaBoleta;
    
    private HashMap<String, Producto> productosDefecto= new HashMap<String, Producto>();
    private HashMap<String, PanelProductoIngresar> contenedores= new HashMap<String, PanelProductoIngresar>();
    private PanelProductosIngresar panelProductosIngresar;
    public poolRecalcularProductoIngresar(ControladorFacturaBoleta controladorFacturaBoleta) {
        this.controladorFacturaBoleta=controladorFacturaBoleta;
   
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorFacturaBoleta.setPanelVenderProducto(cargando,  new Dimension(536, 475));
        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){
        PanelProductosIngresar zanelProductosIngresar= new PanelProductosIngresar();
        int contador=0;
        double precioTotal=0;
        String poner="";
        HashMap<String, Producto> valores=controladorFacturaBoleta.getProductosIngresar();
        ArrayList<Producto> productosBuscados=new ArrayList<Producto>();
        valores.values().forEach(tab -> {
            productosBuscados.add(tab);
       });
        
        
        
        
        HashMap<String, PanelProductoIngresar> panelesVender=controladorFacturaBoleta.getContenedoresVender();
        ArrayList<String> productosBuscadosContenedores=new ArrayList<String>();
        valores.keySet().forEach(ta -> {
         productosBuscadosContenedores.add(ta);
        });
        /*if(panelesVender.size()<6){
            for(int a=0;a<6;a++){
                JPanel pane=new javax.swing.JPanel();
                pane.setBackground(new Color(37,31,52));
                zanelProductosIngresar.productosVen.add(pane,0);
                zanelProductosIngresar.productosVen.updateUI();
            }
        }*/

        System.out.println(" producto "+(productosBuscados.size()));
        for(int n=0;n<valores.size();n++){
            
            Producto pa=productosBuscados.get(n);
            String indice=""+pa.getIdProducto();
            PanelProductoIngresar c=new PanelProductoIngresar(indice,controladorFacturaBoleta);   
            c.botonEliminar.setActionCommand("eliminar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.cantidad.setText(""+pa.getCantidad());
            contenedores.put(indice,c);
            String precioas=String.format("%.2f",pa.getCantidad()*pa.getPrecioEntrada());
            c.Total.setText(precioas);
            c.codigoBarras.setText(pa.getCodigoBarras());
            productosDefecto.put(indice, pa);
            c.precioProducto.setText(""+pa.getPrecioSalida());
            c.precioCompra.setText(""+pa.getPrecioEntrada());
            c.nombreProducto.setText(""+pa.getNombre());
            Double cantidadd=pa.getCantidad();
         
            precioTotal=precioTotal+pa.getPrecioEntrada()*cantidadd;
       
            
      

            contador++;
            zanelProductosIngresar.productosVen.add(c,0);
            zanelProductosIngresar.productosVen.updateUI();
        }



        poner=String.format("%.2f",precioTotal);
        controladorFacturaBoleta.setPanelVenderProducto(zanelProductosIngresar,  new Dimension(536, 475));
   
        controladorFacturaBoleta.getGestionarTiendaPrincipal().totalPrecio.setText(poner);
        controladorFacturaBoleta.setContenedoresVender(contenedores);
        controladorFacturaBoleta.setProductosVender(productosDefecto);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");

        if(evento[0].equals("eliminar")){
            String id= evento[1];
            controladorFacturaBoleta.getProductosIngresar().remove(id);
            controladorFacturaBoleta.getContenedoresVender().remove(id);
            controladorFacturaBoleta.proceso("BotonIngresarProducto");
            
        }
    }    
    
    
}
