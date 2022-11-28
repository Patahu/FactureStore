/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.Horario;
import clasesJDBC.HorarioJDBC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarHorarios implements Callable<String> {
    private ControladorGestionarTienda controladorEntrada;
    public poolBuscarHorarios(ControladorGestionarTienda controladorEntrada) {
        this.controladorEntrada=controladorEntrada;
    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        ArrayList<Horario> horarios= horarioJDBC.buscarHorariosActivos();
        String horarioActual="NINGUNO";
        HashMap<String, Horario> turnosDE=new HashMap<String, Horario>();
        for (Horario hr: horarios) {
            horarioActual=hr.getNombre();
            turnosDE.put(horarioActual,hr);
            this.controladorEntrada.setNombreHorario(horarioActual);
        }
        this.controladorEntrada.setTurnosDE(turnosDE);
        

             
               

        return "poolEntrada terminado";
    }
       
}
