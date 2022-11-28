/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda;

import GUI_limbo.*;
import GUI_limbo.entrada.GestionarTiendaInicio;
import GUI.ControladorPrincipal;
import GUILoading.Cargando;
import GUI_InicioSesion.InicioSesion;
import GUI_Tienda.caja.ControladorTiendaCaja;
import GUI_Tienda.principal.ControladorTiendaPrincipal;
import GUI_Tienda.producto.ControladorTiendaProducto;
import GUI_Tienda.reportes.ControladorTiendaReportes;
import GUI_limbo.entrada.ControladorGestionarTienda;
import GUI_limbo.gestionar_horarios.ControladorHorarios;
import GUI_limbo.gestionar_usuarios.ControladorUsuarios;
import clases.Caja;
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
public class ControladorTienda implements ActionListener{
    private ControladorPrincipal controladorPrincipal;
    private volatile Tienda tienda; 

    private ControladorTiendaPrincipal contraladorTiendaPrincipal=null;
    private Caja caja;
    public ControladorTienda(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;

        this.tienda=new Tienda();
        this.tienda.cerrarSesion.addActionListener(this);
        this.tienda.gestionarTienda.addActionListener(this);
        this.tienda.volver.addActionListener(this);
        this.tienda.gestionarProducto.addActionListener(this);
        this.tienda.gestionarCaja.addActionListener(this);
        this.tienda.gestionarReporte.addActionListener(this);
 
    }
    public void iniciarTienda(){
        Cargando cargando= new Cargando();
        controladorPrincipal.setPanelControladorPrincipal(  new Dimension(516, 500),cargando);
        controladorPrincipal.setPanelControladorPrincipal(new Dimension(1100,746), tienda);
        this.tienda.user.setText(controladorPrincipal.getUsuario().getNombreUsuario());
        this.tienda.rol.setText("Administrador");
        if(controladorPrincipal.getUsuario().getIsAdmin()!=1){
              this.tienda.rol.setText("Vendedor");
            tienda.gestionarProducto.setVisible(false);

        }
        procesos("gestionarTienda");
    }
    public void procesos(String tipo){
        if(tipo.equals("gestionarTienda")){
            if(contraladorTiendaPrincipal==null){
                this.contraladorTiendaPrincipal= new ControladorTiendaPrincipal(this,controladorPrincipal.getUsuario());
                contraladorTiendaPrincipal.iniciar();
            }else{
                contraladorTiendaPrincipal.continuar();
            }
            
        }else if(tipo.equals("gestionarProducto")){
            ControladorTiendaProducto contraladorHorarios= new ControladorTiendaProducto(this,controladorPrincipal.getUsuario());
            contraladorHorarios.iniciar();
        }else if(tipo.equals("gestionarCaja")){//gestionarCaja
            ControladorTiendaCaja controladorTiendaCaja= new ControladorTiendaCaja(this);
            controladorTiendaCaja.iniciar();
        }else if(tipo.equals("gestionarReporte")){//gestionarReporte
            ControladorTiendaReportes controladorTiendaReportes= new ControladorTiendaReportes(this);
            controladorTiendaReportes.iniciar();
        }
    
    }
    
    public void setPanelControladorTienda(JPanel panel, Dimension dimension){
        this.tienda.jPanel2.removeAll();
        this.tienda.jPanel2.setSize(dimension);
        panel.setSize(dimension);
        
        this.tienda.jPanel2.add(panel,GridLayout.class);
        this.tienda.jPanel2.revalidate();
        this.tienda.jPanel2.repaint();
        
    }

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cerrar Sesión":
                controladorPrincipal.proceso("inicioSesion");
                break;
            case "gestionarProducto":
                procesos(e.getActionCommand());
                break;
            case "volver":
                controladorPrincipal.proceso("limbo");
                break;
            case "gestionarTienda":
                procesos(e.getActionCommand());
                break;
            case "gestionarCaja":
                procesos(e.getActionCommand());
                break;
            case "gestionarReporte":
                procesos(e.getActionCommand());
            default:
                break;
        }

    }
}
