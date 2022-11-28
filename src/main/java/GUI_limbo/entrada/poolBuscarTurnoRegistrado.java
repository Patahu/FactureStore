/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.Horario;
import clases.TurnoRegistrado;
import clases.Usuario;
import clasesJDBC.HorarioJDBC;
import clasesJDBC.TurnoRegistradoJDBC;
import clasesJDBC.UsuarioJDBC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 *
 * @author fell
 */
public class poolBuscarTurnoRegistrado implements Callable<String>{
    private ControladorGestionarTienda controladorEntrada;
    private Usuario usuario;
    public poolBuscarTurnoRegistrado(ControladorGestionarTienda controladorEntrada,Usuario usuario) {
        this.controladorEntrada=controladorEntrada;
        this.usuario=usuario;
    }
    
    @Override
    public String call() throws Exception {

        TurnoRegistradoJDBC turnoRegistradoJDBC=new TurnoRegistradoJDBC();
        ArrayList<TurnoRegistrado> turnoRegistrados= turnoRegistradoJDBC.buscarTurnosTodos();
     
        if(turnoRegistrados.size()==0){
            this.controladorEntrada.setTurno(null,usuario,null,0);
            HorarioJDBC horarioJDBC=new HorarioJDBC();
            ArrayList<Horario> horarios= horarioJDBC.buscarHorariosActivos();
            String horarioActual="NINGUNO";
            HashMap<String, Horario> turnosDE=new HashMap<String, Horario>();
            this.controladorEntrada.getEntrada().horarioAtencion.removeAllItems();
            for (Horario hr: horarios) {
                horarioActual=hr.getNombre();
                turnosDE.put(horarioActual,hr);
                this.controladorEntrada.setNombreHorario(horarioActual);
            }
            this.controladorEntrada.setTurnosDE(turnosDE);
        }else{
            
            UsuarioJDBC usuarioJDBC=new UsuarioJDBC();
            HorarioJDBC horario= new HorarioJDBC();
            Usuario usuarioBuscado=usuarioJDBC.buscarUsuario(new Usuario(turnoRegistrados.get(0).getIdUsuario()));
            Horario horarioBuscado=horario.buscarHorariosId(turnoRegistrados.get(0).getIdHorario());

            this.controladorEntrada.setTurno(turnoRegistrados.get(0),usuarioBuscado,horarioBuscado,turnoRegistrados.get(0).getRespuesta()); 
        }
 

        return "poolEntrada terminado";
    }  
}
