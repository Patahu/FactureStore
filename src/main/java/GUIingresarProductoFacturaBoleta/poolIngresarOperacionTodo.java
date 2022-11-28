/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIingresarProductoFacturaBoleta;

import GUI_Tienda.principal.*;
import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.OperacionProducto;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.OperacionProductoJDBC;
import clasesJDBC.ProductoJDBC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class poolIngresarOperacionTodo implements Callable<String> {

    
    private ControladorFacturaBoleta controladorFacturaBoleta;
    
    private HashMap<String, Producto> productosDefecto= new HashMap<String, Producto>();

    private PanelProductosSubFactura panelProductosSubFactura;
    public poolIngresarOperacionTodo(ControladorFacturaBoleta controladorFacturaBoleta) {
        this.controladorFacturaBoleta=controladorFacturaBoleta;
   
    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolIngresarFactura Terminado";
    }
    
    
    public void mostrarHorarios(){
      
        OperacionProductoJDBC pperacionProductoJDBC=new OperacionProductoJDBC();
        System.out.println("COMENZAMOS INGRESO 0");
        String idOperacionProducto=""+controladorFacturaBoleta.getUsuario().getIdUsuario()+""+(int) System.currentTimeMillis();
        System.out.println("COMENZAMOS INGRESO1");
        int idUsuario=controladorFacturaBoleta.getUsuario().getIdUsuario();
        String numeroSerie=controladorFacturaBoleta.getGestionarTiendaPrincipal().numero.getText();
        System.out.println("COMENZAMOS INGRESO 2");
        double precioTotal=controladorFacturaBoleta.getPrecioVoucher();
        String tipo="BOLETA/FACTURA";
        System.out.println("COMENZAMOS INGRESO 3");
        pperacionProductoJDBC.insertaOperacionProducto(new OperacionProducto(idOperacionProducto, 
            null, 
            idUsuario, 
            null, 
            numeroSerie, 
            precioTotal, 
            tipo));
        HashMap<String, Producto> valores=controladorFacturaBoleta.getProductosIngresar();
        ArrayList<Producto> productosBuscados=new ArrayList<Producto>();
        valores.values().forEach(tab -> {
            productosBuscados.add(tab);
       });
       System.out.println("COMENZAMOS productos");
        for(int n=0;n<productosBuscados.size();n++){
            
            pperacionProductoJDBC.insertaOperacionProductoOperacion(productosBuscados.get(n), idOperacionProducto);
        }
        controladorFacturaBoleta.getProductosIngresar().clear();
        controladorFacturaBoleta.proceso("BotonIngresarProducto");
       
    }

}
