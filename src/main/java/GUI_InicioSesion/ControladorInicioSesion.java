/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_InicioSesion;

import GUI.ControladorPrincipal;
import GUILoading.Cargando;
import GUI_limbo.Limbo;
import clases.Usuario;
import clasesJDBC.UsuarioJDBC;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;


/**
 *
 * @author fell
 */
public class ControladorInicioSesion implements ActionListener{
    private ControladorPrincipal controladorPrincipal;
    private volatile InicioSesion inicioSesion;

    public ControladorInicioSesion(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
  

       
    }
    public void iniciarInicioSesion(){
        this.inicioSesion=new InicioSesion();
        this.inicioSesion.botonIngresar.addActionListener(this);
        this.inicioSesion.botonSalir.addActionListener(this);
        controladorPrincipal.setPanelControladorPrincipal(new Dimension(500, 680), inicioSesion);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buscar(e.getActionCommand());
        
    }
    private void buscar(String procedencia){
        if(procedencia.equals("Ingresar")){
            String passText = new String(inicioSesion.passwordTextField.getPassword());
            Usuario usuario=new Usuario(inicioSesion.usuarioTextField.getText(),passText);
            if(usuario.getNombreUsuario().equals("")){
                inicioSesion.usuarioTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Datos Vacios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 8), new java.awt.Color(153, 0, 0)));
                if(passText.equals("")){
                    inicioSesion.passwordTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Datos Vacios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 8), new java.awt.Color(153, 0, 0)));
                    return;
                }
                return;
            }

            
            controladorPrincipal.proceso("cargando");
            
            Future<String> task1= controladorPrincipal.getExec().submit(new poolLlamarUsuario(this,usuario));
            

        }else{
            controladorPrincipal.getPrincipal().dispose();
        
        
        }
    }
    public void continuar(EstadoInicioSesion estadoInicioSesion){
            if(estadoInicioSesion.getResultado().equals("encontrado")){
                controladorPrincipal.setUsuario(estadoInicioSesion.getUsuario());
                controladorPrincipal.proceso("limbo");

            }else if(estadoInicioSesion.getResultado().equals("no encontrado")){
                inicioSesion.panelInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos incorrectos usuario no encontrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 0, 0)));
                controladorPrincipal.setPanelControladorPrincipal(new Dimension(500, 680), inicioSesion);
            }
    }




    
    
}
