/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto;

import GUI_Tienda.ControladorTienda;
import GUI_Tienda.producto.gestionarCategoria.ControladorCategoria;
import GUI_Tienda.producto.gestionarProducto.ControladorProducto;
import GUIingresarProductoFacturaBoleta.ControladorFacturaBoleta;
import GUIingresarProductoFacturaBoleta.GestionarProductoFactura;
import clases.Usuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorCompletionService;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorTiendaProducto implements ActionListener{
    private ControladorTienda controladorTienda;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarTiendaProductos gestionarTiendaProductos;
    private Usuario usuario;
    
    public ControladorTiendaProducto(ControladorTienda controladorTienda,Usuario usuario) {
        this.controladorTienda=controladorTienda;

        this.usuario=usuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("gestionarProductos")){
            procesoG(e.getActionCommand());
        }else if(e.getActionCommand().equals("gestionarCategorias")){
            procesoG(e.getActionCommand());
        }else if(e.getActionCommand().equals("gestionarVariantes")){
            procesoG(e.getActionCommand());
        }else if(e.getActionCommand().equals("gestionarFacturas")){
            procesoG(e.getActionCommand());
        }
    }

    public ControladorTienda getControladorTienda() {
        return controladorTienda;
    }


    public void procesoG(String tipo){
         if(tipo.equals("gestionarProductos")){

                   
            ControladorProducto controladorProducto= new ControladorProducto(this); 
            controladorProducto.iniciarS();
            
        
        }else if(tipo.equals("gestionarCategorias")){
            ControladorCategoria controladorCategoria= new ControladorCategoria(this); 
            controladorCategoria.iniciar();
            //Future<String> task1= exec.submit(new poolIngresarUsuarios(this,(String) ingresarUsuario.turno.getSelectedItem()));  
        
        }else if(tipo.equals("gestionarVariantes")){
            

            //Future<String> task1= exec.submit(new poolBuscarHorariosModificar(modificarUsuarios,usuarioModificar.getIdHorario())); 
      
        
        }else if(tipo.equals("gestionarFacturas")){
            ControladorFacturaBoleta estionarProductoFactura= new ControladorFacturaBoleta(this,usuario); 
            estionarProductoFactura.iniciar();
        }
    }
    public void iniciar(){
        this.gestionarTiendaProductos= new GestionarTiendaProductos();
        gestionarTiendaProductos.gestionarProductos.addActionListener(this);
        gestionarTiendaProductos.gestionarCategorias.addActionListener(this);
        gestionarTiendaProductos.gestionarFacturas.addActionListener(this);
        controladorTienda.setPanelControladorTienda(gestionarTiendaProductos,  new Dimension(1100,620));
        
        procesoG("gestionarProductos");

        
    }   
    
    public void setPanelControladorTiendaProducto(JPanel panel, Dimension dimension){
        gestionarTiendaProductos.aquiHor.removeAll();
        gestionarTiendaProductos.aquiHor.setSize(dimension);
        panel.setSize(dimension);
       
    
        gestionarTiendaProductos.aquiHor.add(panel,GridLayout.class);
        gestionarTiendaProductos.aquiHor.revalidate();
        gestionarTiendaProductos.aquiHor.repaint();
    }
}
