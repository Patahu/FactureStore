/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

import GUI_Tienda.producto.ControladorTiendaProducto;
import GUI_Tienda.producto.gestionarProducto.GestionarProductos;
import GUI_Tienda.producto.gestionarProducto.PanelIngresarProducto;
import GUI_Tienda.producto.gestionarProducto.poolBuscarGestionarProducto;
import GUI_Tienda.producto.gestionarProducto.poolBuscarProductoNombre;
import GUI_Tienda.producto.gestionarProducto.poolInsertarProducto;
import clases.Categoria;
import clases.Producto;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorCategoria implements ActionListener{
    private ControladorTiendaProducto controladorTiendaProducto;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarCategoria gestionarCategorias;
    private volatile PanelIngresarCategoria panelIngresarCategoria;
    private volatile PanelIngresarCategoria panelIngresarModificar;
    private Categoria categoriaSeleccionado;
    public ControladorCategoria(ControladorTiendaProducto controladorTiendaProducto) {
        this.controladorTiendaProducto=controladorTiendaProducto;
        this.exec=controladorTiendaProducto.getControladorTienda().getControladorPrincipal().getExec();
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("buscarCategoria")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("ingresarCategoria")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("volver")){
            iniciar();
        }else if(e.getActionCommand().equals("Ingresar insertar")){
            Future<String> task1= exec.submit(new poolInsertarCategoria(this)); 
          
        }else if(e.getActionCommand().equals("cambioText")){
            Future<String> task1= exec.submit(new poolBuscarCategoriaNombre(this)); 
        
        }else if(e.getActionCommand().equals("Ingresar modificar")){
            
            Future<String> task1= exec.submit(new poolModificarCategoria(this)); 

        }
    }


    public void proceso(String tipo){
        if(tipo.equals("buscarCategoria")){              
            Future<String> task1= exec.submit(new poolBuscarGestionarCategoria(this));
 
        }else if(tipo.equals("ingresarCategoria")){
            
            panelIngresarCategoria= new PanelIngresarCategoria(); 
            panelIngresarCategoria.volver.addActionListener(this);
            panelIngresarCategoria.cancelar.addActionListener(this);
            panelIngresarCategoria.ingresar.addActionListener(this);

            controladorTiendaProducto.setPanelControladorTiendaProducto(panelIngresarCategoria, new Dimension(1100,530));
            //Future<String> task1= exec.submit(new poolIngresarUsuarios(this,(String) ingresarUsuario.turno.getSelectedItem()));  
        
        }else if(tipo.equals("ingresarModificar")){
            
             panelIngresarModificar= new PanelIngresarCategoria(); 
             panelIngresarModificar.volver.addActionListener(this);
             panelIngresarModificar.cancelar.addActionListener(this);
             panelIngresarModificar.ingresar.addActionListener(this);
             panelIngresarModificar.ingresar.setActionCommand("Ingresar modificar");
             panelIngresarModificar.ingresar.setText("Actualizar");
             panelIngresarModificar.nombreCategoria.setText(""+categoriaSeleccionado.getNombre());
             panelIngresarModificar.descripcion.setText(""+categoriaSeleccionado.getDescripcion());
             panelIngresarModificar.fechaCreacion.setText(""+categoriaSeleccionado.getFechaCreacion());
             controladorTiendaProducto.setPanelControladorTiendaProducto(panelIngresarModificar, new Dimension(1100,530));
        }else if(tipo.equals("Eliminar Categoria")){
       
            Future<String> task1= exec.submit(new poolEliminarCategoria(this)); 
        }
    }
    public void iniciar(){
        this.gestionarCategorias= new GestionarCategoria(this);
        gestionarCategorias.ingresarCategoria.addActionListener(this);
        gestionarCategorias.buscarCategoria.addActionListener(this);
        
        controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarCategorias,  new Dimension(1100,530));
        proceso("buscarCategoria");
   
    }  

    public Categoria getCategoriaSeleccionado() {
        return categoriaSeleccionado;
    }

    public void setCategoriaSeleccionado(Categoria categoriaSeleccionado) {
        this.categoriaSeleccionado = categoriaSeleccionado;
    }

    public GestionarCategoria getGestionarCategorias() {
        return gestionarCategorias;
    }

    public PanelIngresarCategoria getPanelIngresarCategoria() {
        return panelIngresarCategoria;
    }

    public PanelIngresarCategoria getPanelIngresarModificar() {
        return panelIngresarModificar;
    }
    
    
    
    
    public void setPanelControladorCategoria(JPanel panel, Dimension dimension){
        gestionarCategorias.aquiHor.removeAll();
        gestionarCategorias.aquiHor.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarCategorias.aquiHor.add(panel,GridLayout.class);
        gestionarCategorias.aquiHor.revalidate();
        gestionarCategorias.aquiHor.repaint();
    } 
}
