/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI_InicioSesion.ControladorInicioSesion;
import GUI_InicioSesion.InicioSesion;
import GUI.Principal;
import GUILoading.Cargando;
import GUI_Tienda.ControladorTienda;
import GUI_limbo.ControladorLimbo;
import GUI_limbo.Limbo;
import clases.Usuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorPrincipal {
    private Principal principal;
    private Usuario usuario;
    private ExecutorService executor=Executors.newFixedThreadPool(1);
    private volatile ExecutorCompletionService<String> completionService=new ExecutorCompletionService<>(executor);
    public ControladorPrincipal(Principal principal) {
        this.principal=principal;
    }

    public ExecutorCompletionService<String> getExec() {
        return completionService;
    }


    
    public void iniciar(){
        this.principal.setVisible(true);
        this.principal.setTitle("Banni");
        proceso("inicioSesion");
        //
    }
    public void proceso(String paso){
        // iniciamos llamando al controlador Iniciar Sesion
        if(paso.equals("inicioSesion")){
           ControladorInicioSesion controladorInicioSesion=new ControladorInicioSesion(this);  
           controladorInicioSesion.iniciarInicioSesion();
        }else if(paso.equals("limbo")){
   
            ControladorLimbo controladorLimbo=new ControladorLimbo(this);
            controladorLimbo. iniciarLimbo();
        
        }else if(paso.equals("cargando")){
            Cargando cargando= new Cargando();
            
            setPanelControladorPrincipal(new Dimension(400, 500), cargando);
        }else if(paso.equals("entrar tienda")){
            ControladorTienda controladorTienda=new ControladorTienda(this);
            controladorTienda.iniciarTienda();
        }
      
    }
    public void setPanelControladorPrincipal(Dimension dimension, JPanel panel){
        principal.panelPrincipal.removeAll();
        principal.setSize(dimension);
        panel.setSize(dimension);
        
        principal.panelPrincipal.add(panel,GridLayout.class);
        principal.panelPrincipal.revalidate();
        principal.panelPrincipal.repaint();
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Principal getPrincipal() {
        return principal;
    }

}
