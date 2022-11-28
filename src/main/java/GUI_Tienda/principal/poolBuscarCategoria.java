/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import GUI_Tienda.producto.gestionarCategoria.*;
import GUILoading.Cargando;
import clases.Categoria;
import clasesJDBC.CategoriaJDBC;
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
public class poolBuscarCategoria implements Callable<String> {

    
    private ControladorTiendaPrincipal controladorTiendaPrincipal;

    public poolBuscarCategoria(ControladorTiendaPrincipal controladorTiendaPrincipal) {
        this.controladorTiendaPrincipal=controladorTiendaPrincipal;
    }
    
    @Override
    public String call() throws Exception {

        mostrarHorarios();
        return "poolBuscarCategorias Terminado";
    }
    
    
    public void mostrarHorarios(){


        CategoriaJDBC categoriaBuscado= new CategoriaJDBC();
        ArrayList<Categoria> categiriasBuscados=categoriaBuscado.buscarCategoriasTodos();
        controladorTiendaPrincipal.getGestionarTiendaPrincipal().categorias.removeAllItems();
        for(Categoria c:categiriasBuscados){
            controladorTiendaPrincipal.getGestionarTiendaPrincipal().categorias.addItem(c.getNombre());
        }
        
        
    }
  
}
