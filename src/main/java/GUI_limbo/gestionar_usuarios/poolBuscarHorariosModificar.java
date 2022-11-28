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
public class poolBuscarHorariosModificar implements Callable<String>{
    private PanelIngresarUsuario gestionarUsuario;
    private int idHorarioE; 
    private ControladorUsuarios controlador;
    public poolBuscarHorariosModificar(PanelIngresarUsuario gestionarUsuario, int idHorarioE,ControladorUsuarios controlador) {
        this.gestionarUsuario=gestionarUsuario;
        this.idHorarioE=idHorarioE;
        this.controlador=controlador;

    }
    
    @Override
    public String call() throws Exception {
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        ArrayList<Horario> horarios=horarioJDBC.buscarHorariosTodos();
        for(Horario p: horarios){
            gestionarUsuario.turno.addItem(p.getNombre());
            if(p.getIdHorario()==idHorarioE){
                gestionarUsuario.turno.setSelectedItem(p.getNombre());
            }
            
        }
        controlador.setPanelUsuarios(gestionarUsuario, new Dimension(1000,620));
        return "poolModificar Terminado";
    }  
}
