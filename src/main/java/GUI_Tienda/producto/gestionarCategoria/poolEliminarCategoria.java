/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

import clasesJDBC.CategoriaJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolEliminarCategoria implements Callable<String> {
    private ControladorCategoria controladorCategoria;
    public poolEliminarCategoria(ControladorCategoria controladorCategoria) {
        this.controladorCategoria=controladorCategoria;
    }
    
    @Override
    public String call() throws Exception {
         CategoriaJDBC categoriaJDBC= new CategoriaJDBC();
    
        int resultados=categoriaJDBC.eliminaCategoria(controladorCategoria.getCategoriaSeleccionado().getIdCategoria());
        if(resultados==1){
              JOptionPane.showMessageDialog(null, "Se ha eliminado la Categoría");
              controladorCategoria.proceso("buscarCategoria");
        }
        return "poolEliminarCategoria Terminado";
    }  
}
