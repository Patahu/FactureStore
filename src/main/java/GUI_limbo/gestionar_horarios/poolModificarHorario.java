/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_horarios;

import clases.Horario;
import clasesJDBC.HorarioJDBC;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolModificarHorario implements Callable<String> {
    private ControladorHorarios controladorHorarios;
    public poolModificarHorario(ControladorHorarios controladorHorarios) {
        this.controladorHorarios=controladorHorarios;
    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC= new HorarioJDBC();

        Date horaEntrada=(Date) controladorHorarios.modificarHorario.horaEntrada.getValue();
        Date horaSalida=(Date) controladorHorarios.modificarHorario.horaSalida.getValue();
        


        int eleccion = controladorHorarios.modificarHorario.comboTurno.getSelectedIndex();
        if(eleccion==0){
            eleccion =1;
        }else{
            eleccion =0;
        }
        Horario horario=new Horario(controladorHorarios.getHorario().getIdHorario(),horaEntrada,horaSalida,controladorHorarios.modificarHorario.turno.getText(),eleccion);
        int cantidad=horarioJDBC.modificarHorario(horario);
        if(cantidad==1){
            JOptionPane.showMessageDialog(null, "Se ha modificado el horario");
            controladorHorarios.proceso("Cancelar");
        }
        
        return "poolIngresarHorario Terminado";
    }
}
