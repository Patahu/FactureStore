/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_horarios;

import clases.Horario;
import clasesJDBC.HorarioJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolEliminarHorario implements Callable<String>{
    private ControladorHorarios controladorHorarios;
    public poolEliminarHorario(ControladorHorarios controladorHorarios) {
        this.controladorHorarios=controladorHorarios;
    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC= new HorarioJDBC();
        Horario horario=new Horario(controladorHorarios.getHorario().getIdHorario());
        int resultados=horarioJDBC.eliminarHorario(horario);
        if(resultados==1){
              JOptionPane.showMessageDialog(null, "Se ha eliminado el horario");
               controladorHorarios.proceso("Buscar");
           
        }

        return "poolIngresarHorario Terminado";
    }
}
