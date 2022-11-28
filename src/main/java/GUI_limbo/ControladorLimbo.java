/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo;

import GUI_limbo.entrada.GestionarTiendaInicio;
import GUI.ControladorPrincipal;
import GUI_InicioSesion.InicioSesion;
import GUI_limbo.entrada.ControladorGestionarTienda;
import GUI_limbo.gestionar_horarios.ControladorHorarios;
import GUI_limbo.gestionar_usuarios.ControladorUsuarios;
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
public class ControladorLimbo implements ActionListener{
    private ControladorPrincipal controladorPrincipal;
    private volatile Limbo limbo; 
  
    public ControladorLimbo(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        this.limbo=new Limbo();
        this.limbo.cerrarSesion.addActionListener(this);
        this.limbo.gestionarHorarios.addActionListener(this);
        this.limbo.gestionarTienda.addActionListener(this);
        this.limbo.gestionarUsuarios.addActionListener(this);
       
    }

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }
    
    
    public void iniciarLimbo(){
        controladorPrincipal.setPanelControladorPrincipal(new Dimension(1100,746), limbo);
        this.limbo.user.setText(controladorPrincipal.getUsuario().getNombreUsuario());
        this.limbo.rol.setText("Administrador");
        if(controladorPrincipal.getUsuario().getIsAdmin()!=1){
            this.limbo.rol.setText("Vendedor");
            this.limbo.gestionarHorarios.setVisible(false);
            this.limbo.gestionarUsuarios.setVisible(false);
        }
        procesos("gestionarTienda");
    }
    public void procesos(String tipo){
        if(tipo.equals("gestionarTienda")){
            ControladorGestionarTienda contraladorEntrada= new ControladorGestionarTienda(this,controladorPrincipal.getUsuario());
            contraladorEntrada.procesoInicial();
        }else if(tipo.equals("gestionarHorarios")){
            ControladorHorarios contraladorHorarios= new ControladorHorarios(this);
            contraladorHorarios.iniciar();
        }else if(tipo.equals("gestionarUsuarios")){
            ControladorUsuarios contraladorUsuarios= new ControladorUsuarios(this);
            contraladorUsuarios.iniciar();
        }
    
    }
    
    public void setPanelControladorLimbo(JPanel panel, Dimension dimension){
        this.limbo.jPanel2.removeAll();
        this.limbo.jPanel2.setSize(dimension);
        panel.setSize(dimension);
        
        this.limbo.jPanel2.add(panel,GridLayout.class);
        this.limbo.jPanel2.revalidate();
        this.limbo.jPanel2.repaint();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cerrar Sesión":
                controladorPrincipal.proceso("inicioSesion");
                break;
            case "gestionarHorarios":
                procesos(e.getActionCommand());
                break;
            case "gestionarTienda":
                procesos("gestionarTienda");
                break;
            case "gestionarUsuarios":
                procesos("gestionarUsuarios");
                break;
            default:
                break;
        }

    }
}
