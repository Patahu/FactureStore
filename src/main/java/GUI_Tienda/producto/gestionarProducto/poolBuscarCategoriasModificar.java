/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUI_Tienda.producto.ControladorTiendaProducto;
import GUI_limbo.gestionar_usuarios.*;
import clases.Categoria;
import clases.Horario;
import clases.Producto;
import clases.ProductoTienda;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.HorarioJDBC;
import clasesJDBC.ProductoTiendaJDBC;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fell
 */
public class poolBuscarCategoriasModificar implements Callable<String>{
    private PanelIngresarProducto gestionarCategoria;
    private Producto productoSeleccionado; 
    private ControladorTiendaProducto controlador;
    public poolBuscarCategoriasModificar(PanelIngresarProducto panelIngresarProducto, Producto productoSeleccionado,ControladorTiendaProducto controlador) {
        this.gestionarCategoria=panelIngresarProducto;
        this.productoSeleccionado=productoSeleccionado;
        this.controlador=controlador;

    }
    
    @Override
    public String call() throws Exception {
        CategoriaJDBC categoriaJDBC=new CategoriaJDBC();
        ProductoTiendaJDBC productoTiendaJDBC= new ProductoTiendaJDBC();

        ArrayList<Categoria> categorias=categoriaJDBC.buscarCategoriasTodos();
        for(Categoria p: categorias){
            gestionarCategoria.categorias.addItem(p.getNombre());
            if(p.getIdCategoria()==productoSeleccionado.getIdCategoria()){
                gestionarCategoria.categorias.setSelectedItem(p.getNombre());
            }
        }

        ProductoTienda stockMinimo= productoTiendaJDBC.buscarProducto(productoSeleccionado);
        if(stockMinimo!=null){
            gestionarCategoria.stockMinino.setText(""+stockMinimo.getStockMinimo());
            gestionarCategoria.stockMinino.setBorder(new JTextField().getBorder());
            
            
        }else{
            gestionarCategoria.stockMinino.setText(""+0);
            gestionarCategoria.stockMinino.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "El producto no es parte de la tienda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(255, 102, 51)));

        }

        controlador.setPanelControladorTiendaProducto(gestionarCategoria, new Dimension(1100,530));
        return "poolModificar Terminado";
    }  
}
