/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

import GUI_limbo.ControladorLimbo;
import GUI_limbo.gestionar_horarios.GestionarHorarios;
import clases.Usuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorUsuarios implements ActionListener{

    
    private ControladorLimbo controladorLimbo;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarUsuarios gestionarUsuarios;
    protected volatile PanelIngresarUsuario ingresarUsuario;
    protected volatile PanelIngresarUsuario modificarUsuarios;
    private Usuario usuarioModificar=null;
    public ControladorUsuarios(ControladorLimbo controladorLimbo) {
        this.controladorLimbo=controladorLimbo;
        this.exec=controladorLimbo.getControladorPrincipal().getExec();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ingresarUsuario")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("Ingresar insertar")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("Ingresar modificar")){
            proceso(e.getActionCommand());
           
        }else if(e.getActionCommand().equals("Cancelar")){

            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("comboBoxChanged")){
            proceso("Buscar");
        }
        
    }
    protected void ingresarUsuario(Usuario usuario){
            this.usuarioModificar=usuario;
    }
    protected Usuario getUsuario(){
        return usuarioModificar;
    }

    protected PanelIngresarUsuario getPanelModificarUsuarios() {
        return modificarUsuarios;
    }
    

    public void proceso(String tipo){
        if(tipo.equals("Buscar") || tipo.equals("Cancelar")){
            // La 0 en el comboBox es 1
            
            gestionarUsuarios.ingresarUsuario.setEnabled(true);
            gestionarUsuarios.activados.setEnabled(true);
            if(gestionarUsuarios.activados.getSelectedIndex()==0){
               Future<String> task1= exec.submit(new poolBuscarUsuarios(this,1)); 
            
            }else{
                Future<String> task1= exec.submit(new poolBuscarUsuarios(this,0)); 
            }

            
             
        }else if(tipo.equals("ingresarUsuario")){
            ingresarUsuario= new PanelIngresarUsuario();
            ingresarUsuario.cancelar.addActionListener(this);
            ingresarUsuario.ingresar.addActionListener(this);
            ingresarUsuario.volver.addActionListener(this);
            gestionarUsuarios.ingresarUsuario.setEnabled(false);
            gestionarUsuarios.activados.setEnabled(false);
     
            
            ingresarUsuario.ingresar.setActionCommand("Ingresar insertar");
                   
            Future<String> task1= exec.submit(new poolBuscarHorarios(ingresarUsuario,this)); 
            
            
        
        }else if(tipo.equals("Ingresar insertar")){
            Future<String> task1= exec.submit(new poolIngresarUsuarios(this,(String) ingresarUsuario.turno.getSelectedItem()));  
        
        }else if(tipo.equals("Modificar Usuario")){
            
            modificarUsuarios=new PanelIngresarUsuario();

            gestionarUsuarios.ingresarUsuario.setEnabled(false);
            gestionarUsuarios.activados.setEnabled(false);
            modificarUsuarios.ingresar.setActionCommand("Ingresar modificar");
            modificarUsuarios.ingresar.setText("Actualizar");
            modificarUsuarios.nombreUsuario.setText(""+usuarioModificar.getNombreUsuario());
            modificarUsuarios.fechaCreacion.setText(""+usuarioModificar.getFechaCreacion());
            modificarUsuarios.contraseña.setText(usuarioModificar.getPasswordUsuario());
            modificarUsuarios.contraseña2.setText(usuarioModificar.getPasswordUsuario());
            if(usuarioModificar.getIsAdmin()==1){
                modificarUsuarios.rol.removeAllItems();
                modificarUsuarios.rol.addItem("Administrador");
                modificarUsuarios.rol.addItem("Vendedor");
            }
            modificarUsuarios.cancelar.addActionListener(this);
            modificarUsuarios.ingresar.addActionListener(this);
            modificarUsuarios.volver.addActionListener(this);
            Future<String> task1= exec.submit(new poolBuscarHorariosModificar(modificarUsuarios,usuarioModificar.getIdHorario(),this)); 
            //setPanelUsuarios(modificarUsuarios,new Dimension(1000,620));
        
        }else if(tipo.equals("Ingresar modificar")){
            
            Future<String> task1= exec.submit(new poolModificarUsuarios(this,(String) modificarUsuarios.turno.getSelectedItem()));  
        
        }else if(tipo.equals("Eliminar Usuario")){
            
            Future<String> task1= exec.submit(new poolEliminarUsuarios(this));  
        
        }
    }
    public void iniciar(){
        this.gestionarUsuarios= new GestionarUsuarios();
        this.gestionarUsuarios.ingresarUsuario.addActionListener(this);
        this.gestionarUsuarios.activados.addActionListener(this);
        this.controladorLimbo.setPanelControladorLimbo(gestionarUsuarios, new Dimension(1100,620));
        proceso("Buscar");

        
    }

    public void setPanelUsuarios(JPanel panel, Dimension dimension){
        gestionarUsuarios.aquiUsu.removeAll();
        gestionarUsuarios.aquiUsu.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarUsuarios.aquiUsu.add(panel,GridLayout.class);
        gestionarUsuarios.aquiUsu.revalidate();
        gestionarUsuarios.aquiUsu.repaint();
    }   
    
    
    
}
