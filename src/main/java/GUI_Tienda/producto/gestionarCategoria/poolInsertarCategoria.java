/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

import clases.Categoria;
import clasesJDBC.CategoriaJDBC;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolInsertarCategoria implements Callable<String>{
    private ControladorCategoria controladorCategoria;
    public poolInsertarCategoria(ControladorCategoria controladorCategoria) {
        this.controladorCategoria=controladorCategoria;
    }
    
    @Override
    public String call() throws Exception {
        CategoriaJDBC CategoriaJDBC= new CategoriaJDBC();

        String nombre=controladorCategoria.getPanelIngresarCategoria().nombreCategoria.getText();

        String descripcion=controladorCategoria.getPanelIngresarCategoria().descripcion.getText();

        Categoria categoria=new Categoria(nombre,descripcion);
        CategoriaJDBC.insertarCategoria(categoria);
        JOptionPane.showMessageDialog(null, "Se ha ingresado un nuevo producto");
        return "poolIngresarProducto Terminado";
    } 
}
