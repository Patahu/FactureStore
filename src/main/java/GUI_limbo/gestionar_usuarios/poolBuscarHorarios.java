/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

import clases.Horario;
import clasesJDBC.HorarioJDBC;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarHorarios implements Callable<String>{
    private PanelIngresarUsuario gestionarUsuario;
    private ControladorUsuarios controladorUsuarios;
    public poolBuscarHorarios(PanelIngresarUsuario gestionarUsuario,ControladorUsuarios controladorUsuarios) {
        this.gestionarUsuario=gestionarUsuario;
        this.controladorUsuarios=controladorUsuarios;

    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        ArrayList<Horario> horarios=horarioJDBC.buscarHorariosActivos();
        for(Horario p: horarios){
        
            gestionarUsuario.turno.addItem(p.getNombre());
        }
        controladorUsuarios.setPanelUsuarios(gestionarUsuario,new Dimension(1000,620));
        return "poolIngresarHoraio Terminado";
    }
    
}
