/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

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
public class poolBuscarGestionarCategoria implements Callable<String>,ActionListener {

    
    private ControladorCategoria controladorCategorias;
    
    private HashMap<String, Categoria> categoriasDefecto= new HashMap<String, Categoria>();
    private HashMap<String, PanelTiendaCategoria> contenedores= new HashMap<String, PanelTiendaCategoria>();
    private PanelCategoriasTienda panelCategoriasTienda;
    public poolBuscarGestionarCategoria(ControladorCategoria controladorCategorias) {
        this.controladorCategorias=controladorCategorias;
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorCategorias.setPanelControladorCategoria(cargando,new Dimension(630,450));

        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){

        panelCategoriasTienda= new PanelCategoriasTienda();
        int contador=0;
        CategoriaJDBC categoriaBuscado= new CategoriaJDBC();
        ArrayList<Categoria> categiriasBuscados=categoriaBuscado.buscarCategoriasTodos();
        for(Categoria pa: categiriasBuscados){
            
            String indice=""+contador;

            PanelTiendaCategoria c=new PanelTiendaCategoria();   
            c.botonEliminar.setActionCommand("BotonEliminar,"+indice);
            c.botonModificar.setActionCommand("BotonModificar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.botonModificar.addActionListener(this);

            contenedores.put(indice,c);
            c.idcategoria.setText(""+pa.getIdCategoria());
            c.nombreCategoria.setText(""+pa.getNombre());
            c.fechaCreacion.setText(""+pa.getFechaCreacion());
            c.descripcion.setText(""+pa.getDescripcion());
            this.categoriasDefecto.put(indice, pa);
            contador++;
            panelCategoriasTienda.panelD.add(c,0);
            panelCategoriasTienda.panelD.updateUI();
        }
        
        controladorCategorias.setPanelControladorCategoria(panelCategoriasTienda,  new Dimension(630,450));

         
        
    }
    public void eliminarHorarios(String id){
        controladorCategorias.setCategoriaSeleccionado(categoriasDefecto.get(id));
        panelCategoriasTienda.panelD.remove(contenedores.get(id));
        contenedores.remove(id);
        categoriasDefecto.remove(id);
        panelCategoriasTienda.panelD.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("BotonEliminar")){
            String id= evento[1];
            controladorCategorias.setCategoriaSeleccionado(categoriasDefecto.get(id));
            controladorCategorias.proceso("Eliminar Categoria");
            System.out.println(" ELIMINAR "+ id);
           
        }else if(evento[0].equals("BotonModificar")){
            String id= evento[1];
            controladorCategorias.setCategoriaSeleccionado(categoriasDefecto.get(id));
            controladorCategorias.proceso("ingresarModificar");
            System.out.println(" MODIFICAR "+id);
        
        }
    }    
}
