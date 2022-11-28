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
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolIngresarHorario implements Callable<String>{
    private ControladorHorarios controladorHorarios;
    public poolIngresarHorario(ControladorHorarios controladorHorarios) {
        this.controladorHorarios=controladorHorarios;
    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC= new HorarioJDBC();
        
        
        Date horaEntrada=(Date) controladorHorarios.ingresarHorario.horaEntrada.getValue();
        Date horaSalida=(Date) controladorHorarios.ingresarHorario.horaSalida.getValue();

        
        
        Horario horario=new Horario(horaEntrada,horaSalida,controladorHorarios.ingresarHorario.turno.getText());
        horarioJDBC.insertarHorario(horario);
        JOptionPane.showMessageDialog(null, "Se ha ingresado un nuevo horario");
        return "poolIngresarHorario Terminado";
    }
    
    
    
}
