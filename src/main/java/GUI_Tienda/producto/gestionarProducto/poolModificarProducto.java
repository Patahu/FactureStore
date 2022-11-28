/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import clases.Categoria;
import clases.Producto;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.ProductoJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolModificarProducto implements Callable<String>{

    private ControladorProducto controladorProducto;
    public poolModificarProducto(ControladorProducto controladorProducto) {
        this.controladorProducto=controladorProducto;
    }

    @Override
    public String call() throws Exception {
        
        ProductoJDBC productoBus= new ProductoJDBC();
        CategoriaJDBC CategoriaJDBC= new CategoriaJDBC();
        PanelIngresarProducto anterior= controladorProducto.getPanelIngresarModificar();
        
        
        Categoria horarioNuevo=CategoriaJDBC.buscarCategoriasNombre((String)anterior.categorias.getSelectedItem());
        
        
        String codigoBarras=anterior.codigoBarras.getText();
        double precioEntrada=Double.parseDouble(anterior.precioCompra.getText());
        double precioSalida=Double.parseDouble(anterior.precioVenta.getText());
        String unidad=(String) anterior.unidades.getSelectedItem();
        int idCategoria=horarioNuevo.getIdCategoria();
        String nombre=anterior.nombreProducto.getText();
        double cantidad=Double.parseDouble(anterior.cantidad.getText());
        double cantidadMinima=Double.parseDouble(anterior.stockMinino.getText());
        System.out.println("Cantidad minima"+cantidadMinima);
        Producto producto=new Producto(codigoBarras,precioEntrada,precioSalida,unidad,idCategoria,nombre,cantidad,cantidadMinima);
        productoBus.insertaProducto(producto);
        JOptionPane.showMessageDialog(null, "Se ha ACTUALIZADO un nuevo producto");
        
        return "poolModificarProducto terminado";
    }
}
