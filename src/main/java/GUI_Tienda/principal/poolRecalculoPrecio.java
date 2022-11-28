/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import GUILoading.Cargando;
import clases.Producto;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolRecalculoPrecio implements Callable<String>{
   
    private ControladorTiendaPrincipal controladorProductos;
    double precioTotal=0;
    public poolRecalculoPrecio(ControladorTiendaPrincipal controladorProductos) {
        this.controladorProductos=controladorProductos;
   
    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolRecalculoPrecio Terminado";
    }
    
    
    public void mostrarHorarios(){

      
       String poner="";

       HashMap<String, PanelProductoVender> valores=controladorProductos.getContenedoresVender();
       ArrayList<String> productosBuscados=new ArrayList<String>();
       valores.keySet().forEach(tab -> {
        productosBuscados.add(tab);
       });
       productosBuscados.forEach(pa -> {
          
           boolean resultado=valores.get(pa).seleccion.isSelected();

           if(resultado){
                double precioProducto=controladorProductos.getProductosVender().get(pa).getPrecioSalida();
                double cantidadVendida=controladorProductos.getProductosVender().get(pa).getCantidadVendida();
                precioTotal=precioTotal+precioProducto*cantidadVendida;
           }
        });

       poner=String.format("%.2f",precioTotal);
       controladorProductos.getGestionarTiendaPrincipal().totalPrecio.setText(poner);
         
        
    }


   
}
