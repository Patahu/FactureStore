/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUI_Tienda.producto.gestionarCategoria.ControladorCategoria;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.ProductoJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolEliminarProducto implements Callable<String>{
  private ControladorProducto controladorProducto;
    public poolEliminarProducto(ControladorProducto controladorProducto) {
        this.controladorProducto=controladorProducto;
    }
    
    @Override
    public String call() throws Exception {
     
        ProductoJDBC productoBus= new ProductoJDBC();
        int resultados=productoBus.eliminaProducto(controladorProducto.getProductoSeleccionado().getIdProducto());
        if(resultados==1){
              JOptionPane.showMessageDialog(null, "Se ha eliminado la Producto");
              controladorProducto.proceso("buscarProducto");
        }
        return "poolEliminarCategoria Terminado";
    }   
}
