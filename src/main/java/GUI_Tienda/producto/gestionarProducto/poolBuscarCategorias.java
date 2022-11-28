/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUI_Tienda.producto.ControladorTiendaProducto;
import clases.Categoria;
import clasesJDBC.CategoriaJDBC;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarCategorias implements Callable<String>{
    private ControladorTiendaProducto controladorTiendaProducto;
    private PanelIngresarProducto gestionarProducto;
    public poolBuscarCategorias(PanelIngresarProducto gestionarProducto,ControladorTiendaProducto controladorTiendaProducto) {
        this.gestionarProducto=gestionarProducto;
        this.controladorTiendaProducto=controladorTiendaProducto;

    }
    
    @Override
    public String call() throws Exception {
        CategoriaJDBC categoriaJDBC=new CategoriaJDBC();
        ArrayList<Categoria> categorias=categoriaJDBC.buscarCategoriasTodos();
        for(Categoria p: categorias){
        
            gestionarProducto.categorias.addItem(p.getNombre());
        }
        controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarProducto, new Dimension(1100,530));
        return "poolIngresarHoraio Terminado";
    }
}
