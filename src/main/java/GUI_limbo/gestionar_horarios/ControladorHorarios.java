/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_horarios;

import GUILoading.Cargando;
import GUI_limbo.ControladorLimbo;
import clases.Horario;
import clases.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author fell
 */
public class ControladorHorarios implements ActionListener{
    private ControladorLimbo controladorLimbo;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarHorarios gestionarHorarios;
    
    protected volatile PanelIngresarHorario ingresarHorario;
    protected volatile PanelIngresarHorario modificarHorario;
    private Horario horarioModificar=null;
    public ControladorHorarios(ControladorLimbo controladorLimbo) {
        this.controladorLimbo=controladorLimbo;
        this.exec=controladorLimbo.getControladorPrincipal().getExec();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ingresarHorario")){
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
    protected void ingresarHorario(Horario horario){
            this.horarioModificar=horario;
    }
    protected Horario getHorario(){
        return horarioModificar;
    }

    public void proceso(String tipo){
        if(tipo.equals("Buscar") || tipo.equals("Cancelar")){
            // La 0 en el comboBox es 1
            
            gestionarHorarios.ingresarHorario.setEnabled(true);
            gestionarHorarios.activados.setEnabled(true);
            if(gestionarHorarios.activados.getSelectedIndex()==0){
                Future<String> task1= exec.submit(new poolBuscarHorarios(this,1)); 
            
            }else{
                Future<String> task1= exec.submit(new poolBuscarHorarios(this,0)); 
            }

            
             
        }else if(tipo.equals("ingresarHorario")){
            ingresarHorario= new PanelIngresarHorario();
            ingresarHorario.cancelar.addActionListener(this);
            ingresarHorario.ingresar.addActionListener(this);
            ingresarHorario.volver.addActionListener(this);
            gestionarHorarios.ingresarHorario.setEnabled(false);
            gestionarHorarios.activados.setEnabled(false);
            ingresarHorario.ingresar.setActionCommand("Ingresar insertar");
            
            setPanelHorarios(ingresarHorario,new Dimension(1000,620));
            
        
        }else if(tipo.equals("Ingresar insertar")){
            Future<String> task1= exec.submit(new poolIngresarHorario(this));  
        
        }else if(tipo.equals("Modificar Horario")){
            
            modificarHorario=new PanelIngresarHorario();
            Date horaEntrada=horarioModificar.getHoraEntrada();  
            Date horaSalida=horarioModificar.getHoraSalida();
            gestionarHorarios.ingresarHorario.setEnabled(false);
            gestionarHorarios.activados.setEnabled(false);
            SpinnerDateModel horaEntradaTransforamda=new SpinnerDateModel(horaEntrada, null, null,Calendar.HOUR_OF_DAY);
            SpinnerDateModel horaSalidaTransforamda=new SpinnerDateModel(horaSalida, null, null,Calendar.HOUR_OF_DAY);
            modificarHorario.horaEntrada.setModel(horaEntradaTransforamda);
            modificarHorario.horaSalida.setModel(horaSalidaTransforamda);
            JSpinner.DateEditor de2 = new JSpinner.DateEditor(modificarHorario.horaEntrada, "HH:mm");
            JSpinner.DateEditor de3 = new JSpinner.DateEditor(modificarHorario.horaSalida, "HH:mm");
            modificarHorario.horaEntrada.setEditor(de2);
            modificarHorario.horaSalida.setEditor(de3);
            //ingresarHorario1.horaEntrada.setValue(""+horarioModificar.getHoraEntrada());
            //ingresarHorario1.horaSalida.setValue(""+horarioModificar.getHoraSalida());
            modificarHorario.ingresar.setActionCommand("Ingresar modificar");
            modificarHorario.ingresar.setText("Actualizar");
            modificarHorario.turno.setText(horarioModificar.getNombre());
            modificarHorario.fechaCreacion.setText(""+horarioModificar.getFechaCreacion());
            modificarHorario.comboTurno.setEnabled(true);
            modificarHorario.cancelar.addActionListener(this);
            modificarHorario.ingresar.addActionListener(this);
            modificarHorario.volver.addActionListener(this);
            setPanelHorarios(modificarHorario,new Dimension(1000,620));
        
        }else if(tipo.equals("Ingresar modificar")){
            
            Future<String> task1= exec.submit(new poolModificarHorario(this));  
        
        }else if(tipo.equals("Eliminar Horario")){
            
            Future<String> task1= exec.submit(new poolEliminarHorario(this));  
        
        }
    }
    public void iniciar(){
        this.gestionarHorarios= new GestionarHorarios();
        this.gestionarHorarios.ingresarHorario.addActionListener(this);
        this.gestionarHorarios.activados.addActionListener(this);
        this.controladorLimbo.setPanelControladorLimbo(gestionarHorarios, new Dimension(1100,620));
        proceso("Buscar");

        
    }

    public void setPanelHorarios(JPanel panel, Dimension dimension){
        gestionarHorarios.aquiHor.removeAll();
        gestionarHorarios.aquiHor.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarHorarios.aquiHor.add(panel,GridLayout.class);
        gestionarHorarios.aquiHor.revalidate();
        gestionarHorarios.aquiHor.repaint();
    }
}
