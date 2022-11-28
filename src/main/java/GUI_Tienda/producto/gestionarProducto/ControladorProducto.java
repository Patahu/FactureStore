/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUI_Tienda.producto.ControladorTiendaProducto;
import GUI_Tienda.producto.GestionarTiendaProductos;
import clases.Producto;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorProducto implements ActionListener{
    private ControladorTiendaProducto controladorTiendaProducto;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarProductos gestionarProductos;
    private volatile PanelIngresarProducto panelIngresarProducto;
    private volatile PanelIngresarProducto panelIngresarModificar;
    private Producto productoSeleccionado;
    public ControladorProducto(ControladorTiendaProducto controladorTiendaProducto) {
       
        this.controladorTiendaProducto=controladorTiendaProducto;
        this.exec=controladorTiendaProducto.getControladorTienda().getControladorPrincipal().getExec();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("buscarProducto")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("ingresarProducto")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("volver")){
            iniciarS();
        }else if(e.getActionCommand().equals("Ingresar insertar")){

           Future<String> task1= exec.submit(new poolInsertarProducto(this)); 
          
        }else if(e.getActionCommand().equals("cambioText")){
            Future<String> task1= exec.submit(new poolBuscarProductoNombre(this)); 
        
        }else if (e.getActionCommand().equals("Ingresar modificar")){
           Future<String> task1= exec.submit(new poolModificarProducto(this));  
        
        }
    }

    public PanelIngresarProducto getPanelIngresarModificar() {
        return panelIngresarModificar;
    }

    
    public void proceso(String tipo){
        if(tipo.equals("buscarProducto")){              
            Future<String> task1= exec.submit(new poolBuscarGestionarProducto(this));
  
        }else if(tipo.equals("ingresarProducto")){
            
            panelIngresarProducto= new PanelIngresarProducto(); 
            panelIngresarProducto.volver.addActionListener(this);
            panelIngresarProducto.cancelar.addActionListener(this);
            panelIngresarProducto.ingresar.addActionListener(this);

            //controladorTiendaProducto.setPanelControladorTiendaProducto(panelIngresarProducto, new Dimension(1100,530));
            Future<String> task1= exec.submit(new poolBuscarCategorias(panelIngresarProducto,controladorTiendaProducto));  
        
        }else if(tipo.equals("ingresarModificar")){
            
             panelIngresarModificar= new PanelIngresarProducto(); 
             panelIngresarModificar.volver.addActionListener(this);
             panelIngresarModificar.cancelar.addActionListener(this);
             panelIngresarModificar.ingresar.addActionListener(this);
             panelIngresarModificar.ingresar.setActionCommand("Ingresar modificar");
             panelIngresarModificar.ingresar.setText("Actualizar");
             panelIngresarModificar.nombreProducto.setText(productoSeleccionado.getNombre());
             panelIngresarModificar.codigoBarras.setText(""+productoSeleccionado.getCodigoBarras());
             panelIngresarModificar.precioVenta.setText(""+productoSeleccionado.getPrecioSalida());
             panelIngresarModificar.precioCompra.setText(""+productoSeleccionado.getPrecioEntrada());
             panelIngresarModificar.cantidad.setText(""+productoSeleccionado.getCantidad());
             panelIngresarModificar.unidades.addItem(productoSeleccionado.getUnidad());
             panelIngresarModificar.fechaCreacion.setText(""+productoSeleccionado.getFechaCreacion());
             Future<String> task1= exec.submit(new poolBuscarCategoriasModificar(panelIngresarModificar,productoSeleccionado,controladorTiendaProducto));  
  
        }else if(tipo.equals("Eliminar Producto")){
            Future<String> task1= exec.submit(new poolEliminarProducto(this));  

        }
    }
    public void iniciarS(){
        this.gestionarProductos= new GestionarProductos(this);
        gestionarProductos.buscarProducto.addActionListener(this);
        gestionarProductos.ingresarProducto.addActionListener(this);
        
        controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarProductos,  new Dimension(1100,530));
        proceso("buscarProducto");
   
    }  

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public GestionarProductos getGestionarProductos() {
        return gestionarProductos;
    }

    public PanelIngresarProducto getPanelIngresarProducto() {
        return panelIngresarProducto;
    }
    
    
    
    
    public void setPanelControladorProducto(JPanel panel, Dimension dimension){
        gestionarProductos.aquiHor.removeAll();
        gestionarProductos.aquiHor.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarProductos.aquiHor.add(panel,GridLayout.class);
        gestionarProductos.aquiHor.revalidate();
        gestionarProductos.aquiHor.repaint();
    }
}
