/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

import clases.Categoria;
import clasesJDBC.CategoriaJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolModificarCategoria implements Callable<String>{
    private ControladorCategoria controladorCategoria;
    public poolModificarCategoria(ControladorCategoria controladorCategoria) {
        this.controladorCategoria=controladorCategoria;
    }
    
    

    @Override
    public String call() throws Exception {
        CategoriaJDBC categoriaJDBC= new CategoriaJDBC();
        int idCategoria=controladorCategoria.getCategoriaSeleccionado().getIdCategoria();
        String nombreCategoria=controladorCategoria.getPanelIngresarModificar().nombreCategoria.getText();
        String descripcion=controladorCategoria.getPanelIngresarModificar().descripcion.getText();
        categoriaJDBC.modificarCategoria(new Categoria(idCategoria,nombreCategoria,descripcion));
        
                
        JOptionPane.showMessageDialog(null, "Se ha modificado una nueva categoria");
        controladorCategoria.proceso("Cancelar");
        return "Modificar producto terminado";
    }
    
}
