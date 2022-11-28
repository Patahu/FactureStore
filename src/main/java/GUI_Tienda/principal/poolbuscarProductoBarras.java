/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

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
public class poolbuscarProductoBarras implements Callable<String>{

   private ControladorTiendaPrincipal controladorProductos;
   private String codigoBarras;
    public poolbuscarProductoBarras(ControladorTiendaPrincipal controladorProductos,String codigoBarras) {
        this.controladorProductos=controladorProductos;
        this.codigoBarras=codigoBarras;
   
    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolCodigoBarras Terminado";
    }
    
    
    public void mostrarHorarios(){
        ProductoJDBC productoBuscado= new ProductoJDBC();
        Producto pro=productoBuscado.buscarProductoBarra(codigoBarras);
        controladorProductos.setProducto(new ProductoVendido(pro,1));
        controladorProductos.proceso("BotonIngresarProducto");
    }
  
    
    
}
