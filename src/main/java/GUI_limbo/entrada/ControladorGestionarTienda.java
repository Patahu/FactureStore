/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;


import GUILoading.Cargando;
import GUI_limbo.ControladorLimbo;
import clases.Caja;
import clases.Horario;
import clases.TurnoRegistrado;
import clases.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author fell
 */
public class ControladorGestionarTienda implements ActionListener{
    private ControladorLimbo controladorLimbo;
    private ExecutorCompletionService<String> exec;
    private Usuario usuario;
    private volatile GestionarTiendaInicio entrada;
    private HashMap<String, Horario> turnosDE;
    private Caja caja;
    private TurnoRegistrado turnoRegistrado;
    public ControladorGestionarTienda(ControladorLimbo controladorLimbo,Usuario usuario) {
        this.controladorLimbo=controladorLimbo;
        this.exec=controladorLimbo.getControladorPrincipal().getExec();
        this.usuario=usuario; 

    }



    public void setTurnosDE(HashMap<String, Horario> turnosDE) {
        this.turnosDE = turnosDE;
    }
    
    public HashMap<String, Horario> getTurnosDE() {
        return turnosDE;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    // Bucle del Limbo
    public void bucle(int orden){
        // orden 1 es para mostrar Caja
        switch (orden) {
            case 1:
                Future<String> task1= exec.submit(new poolBuscarCaja(this));
                break;
            case 2:
                // Orden 2 es para Buscar turno registrado
                Future<String> task3= exec.submit(new poolBuscarTurnoRegistrado(this,usuario));
                break;
            case 3:
                break;
            default:
                break;
        }
    
    }
    public void setPanelControladorCp(Dimension dimension, JPanel panel){
        entrada.removeAll();
        entrada.setSize(dimension);
        panel.setSize(dimension);
        
        entrada.add(panel,GridLayout.class);
        entrada.revalidate();
        entrada.repaint();
    }
    public void procesoInicial(){
        Cargando cargando= new Cargando();
        this.controladorLimbo.setPanelControladorLimbo(cargando,new Dimension(1100,620));
        this.entrada= new GestionarTiendaInicio(usuario);
        this.entrada.iniciarCaja.addActionListener(this);
        this.entrada.cerrarCaja.addActionListener(this);
        this.entrada.registrarTurno.addActionListener(this);
        this.entrada.cerrarTurno.addActionListener(this);
        this.entrada.ingresarTienda.addActionListener(this);
        this.controladorLimbo.setPanelControladorLimbo(entrada, new Dimension(1100,620));
        bucle(1);
        //Future<String> task2= exec.submit(new poolBuscarHorarios(this));
       
    }
    public void setNombreHorario(String horarioUsuario){
        this.entrada.horarioAtencion.addItem(horarioUsuario);   
    }

    public Caja getCaja() {
        return caja;
    }

    public TurnoRegistrado getTurnoRegistrado() {
        return turnoRegistrado;
    }
    
    
    // Ingresamo la Caja
     public void setCaja(Caja caja,Usuario usuario){
        this.caja=caja;
        if(caja==null){
            this.entrada.cajaActual.setText("No iniciada");
            this.entrada.cantidadInicial.setText("0.0"); 
           
            this.entrada.importante.setVisible(false);
            this.entrada.iniciarCaja.setEnabled(true);
            this.entrada.panelTurno.setVisible(false);
            this.entrada.cerrarCaja.setEnabled(false);
            this.entrada.cantidadInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingrese Caja inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10), new java.awt.Color(255, 102, 51)));
            this.entrada.panelCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAJA NO INICIADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 51, 51)));
            
            
            this.entrada.cantidadInicial.setEditable(true);
        }else{
            this.entrada.cerrarCaja.setEnabled(true);
            this.entrada.importante.setVisible(true);

            this.entrada.cajaActual.setText(""+caja.getIdCaja());
            this.entrada.cantidadInicial.setText(""+caja.getInicioCaja());

            this.entrada.cajaActual.setText(""+caja.getCierreCaja());
            this.entrada.fechaCreacion.setText(""+caja.getFechaCreacion());
            this.entrada.usuarioCreador.setText(usuario.getNombreUsuario());
            this.entrada.iniciarCaja.setEnabled(false);
            this.entrada.cantidadInicial.setEditable(false);
            this.entrada.panelTurno.setVisible(true);
            this.entrada.cantidadInicial.setBorder(new JTextField().getBorder());
            this.entrada.panelCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAJA INICIADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(0,255,0)));
        }
        this.entrada.cajaActual.setEditable(false);
        this.entrada.fechaCreacion.setEditable(false);
        this.entrada.usuarioCreador.setEditable(false);
        
        
    }
     // Ingresamo el Turno
    public void setTurno(TurnoRegistrado turnoRegistrado,Usuario usuario,Horario horario,int advertencia){
        this.turnoRegistrado=turnoRegistrado;
        if(turnoRegistrado==null){
            this.entrada.registrarTurno.setEnabled(true);
            this.entrada.cerrarTurno.setEnabled(false);
            this.entrada.nombre.setText(usuario.getNombreUsuario());
            this.entrada.cierreUsuario.setText(""+caja.getCierreCaja());
            this.entrada.panelTurno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TURNO NO INICIADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 51, 51)));
      
        }else{
            this.entrada.registrarTurno.setEnabled(false);
            System.out.println(" PRUEBA : usuario actual"+ this.usuario.getIdUsuario()+ "   usuario Creador:"+usuario.getIdUsuario());
            if(usuario.getIdUsuario()==this.usuario.getIdUsuario()){
                this.entrada.cerrarTurno.setEnabled(true);
            }else{
                this.entrada.cerrarTurno.setEnabled(false);
            }
            this.entrada.nombre.setText(usuario.getNombreUsuario());
            this.entrada.cierreUsuario.setText(""+caja.getCierreCaja());
            this.entrada.horarioAtencion.removeAllItems();
            this.entrada.horarioAtencion.addItem(horario.getNombre());
            System.out.println(" ADVERNTENCAIA :"+advertencia);
            if(advertencia==1){
                this.entrada.panelTurno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TURNO REGISTRADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(0,255,0)));

            }else if(advertencia==2){
                this.entrada.panelTurno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TURNO REGISTRADO TERMINADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255,255,0)));
    
            }
        }
 
        
    
     }
    public GestionarTiendaInicio getEntrada() {
        return entrada;
    }

    public void setEntrada(GestionarTiendaInicio entrada) {
        this.entrada = entrada;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "iniciarCaja" -> {
                Object[] choices = {"Sí", "No"};
                Object defaultChoice = choices[0];
                int input=JOptionPane.showOptionDialog(null,
                        "¿Desea iniciar CAJA con "+this.entrada.cantidadInicial.getText()+"?",
                        "INICIAR CAJA",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        choices,
                        defaultChoice);
                if(input==0){
                    Future<String> task1ss= exec.submit(new poolCrearCaja(this,this.usuario));
                }
            }
            case "ingresarTienda" -> 
            {
                controladorLimbo.getControladorPrincipal().proceso("entrar tienda");
            }
            case "cerrarCaja" -> 
                {
                 Future<String> task1s2= exec.submit(new poolCerrarCaja(this,usuario));
                
            }
            case "cerrarTurno" -> {
                 Future<String> task1s2= exec.submit(new poolCerrarTurnoRegistrado(this,usuario));
                
            }
            case "registrarTurno" -> {
                Future<String> task1s2= exec.submit(new poolCrearTurnoRegistrado(this,usuario));
                
            }
            default -> {
            }
        }
        
        
    }


    
    
    
}
