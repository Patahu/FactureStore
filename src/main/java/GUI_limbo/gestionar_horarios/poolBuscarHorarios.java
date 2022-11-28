/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_horarios;

import GUILoading.Cargando;
import clases.Horario;
import clasesJDBC.HorarioJDBC;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarHorarios implements Callable<String>,ActionListener{
    private ControladorHorarios controladorHorarios;
    
    private HashMap<String, Horario> horariosDefecto= new HashMap<String, Horario>();
    private HashMap<String, PanelHorario> contenedores= new HashMap<String, PanelHorario>();
    private PanelHorarios panelHorarios;
    private int horario;
    public poolBuscarHorarios(ControladorHorarios controladorHorarios,int horario) {
        this.controladorHorarios=controladorHorarios;
        this.horario=horario;
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorHorarios.setPanelHorarios(cargando,new Dimension(700,460));

        mostrarHorarios();
        return "poolBuscarHorarios Terminado";
    }
    
    
    public void mostrarHorarios(){
        HorarioJDBC horarioJDBC= new HorarioJDBC();
        ArrayList<Horario> horariosBuscados;
        
        // si es 1 son activos
        if(horario==1){
            horariosBuscados=horarioJDBC.buscarHorariosActivos();
        }else{
        
            horariosBuscados=horarioJDBC.buscarHorariosInactivos();
        }
 
        panelHorarios= new PanelHorarios();
        int contador=0;
        for(int a=0;a<2;a++){
            panelHorarios.listHorarios.add(new javax.swing.JPanel(),0);
            panelHorarios.listHorarios.updateUI();
        }
        for(Horario pa: horariosBuscados){
            String indice=""+contador;

            PanelHorario c=new PanelHorario();   
            c.botonEliminar.setActionCommand("BotonEliminar,"+indice);
            c.botonModificar.setActionCommand("BotonModificar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.botonModificar.addActionListener(this);
            contenedores.put(indice,c);
            c.turno.setText(pa.getNombre());
            c.horaEntrada.setText(new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(pa.getHoraEntrada())+" HORAS");
            c.horaSalida.setText(new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(pa.getHoraSalida())+" HORAS");
            c.fechaCreacion.setText(""+pa.getFechaCreacion());
            this.horariosDefecto.put(indice, pa);
            if(pa.getIsActive()==1){
                c.activo.setText("SI");
            }else{
                c.activo.setText("NO");
            }
            contador++;
            panelHorarios.listHorarios.add(c,0);
            panelHorarios.listHorarios.updateUI();
        }
        
        controladorHorarios.setPanelHorarios(panelHorarios,  new Dimension(700,460));

         
        
    }
    public void eliminarHorarios(String id){
        controladorHorarios.ingresarHorario(horariosDefecto.get(id));
        panelHorarios.listHorarios.remove(contenedores.get(id));
        contenedores.remove(id);
        horariosDefecto.remove(id);
        panelHorarios.listHorarios.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("BotonEliminar")){
            String id= evento[1];
            controladorHorarios.ingresarHorario(horariosDefecto.get(id));
            controladorHorarios.proceso("Eliminar Horario");
            System.out.println(" ELIMINAR "+ id);
           
        }else if(evento[0].equals("BotonModificar")){
            String id= evento[1];
            controladorHorarios.ingresarHorario(horariosDefecto.get(id));
            controladorHorarios.proceso("Modificar Horario");
            System.out.println(" MODIFICAR "+id);
        
        }
    }
}
