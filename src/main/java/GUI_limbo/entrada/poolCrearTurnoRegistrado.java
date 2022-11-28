/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.TurnoRegistrado;
import clases.Usuario;
import clasesJDBC.TurnoRegistradoJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolCrearTurnoRegistrado implements Callable<String> {
    private ControladorGestionarTienda controladorEntrada;
    private Usuario usuario;
    public poolCrearTurnoRegistrado(ControladorGestionarTienda controladorEntrada,Usuario usuario) {
        this.controladorEntrada=controladorEntrada;
        this.usuario=usuario;
    }
    
    @Override
    public String call() throws Exception {

        TurnoRegistradoJDBC turnoRegistradoJDBC=new TurnoRegistradoJDBC();
        String nombreHorario=this.controladorEntrada.getEntrada().horarioAtencion.getSelectedItem().toString();
        
        turnoRegistradoJDBC.insertarTurnoRegistrado(new TurnoRegistrado(usuario.getIdUsuario(),this.controladorEntrada.getTurnosDE().get(nombreHorario).getIdHorario(),this.controladorEntrada.getCaja().getIdCaja(),this.controladorEntrada.getCaja().getCierreCaja()));
        
        JOptionPane.showMessageDialog(null, "TURNO INICIADO");
        
        this.controladorEntrada.bucle(2);
        
        return "poolEntrada terminado";
    }     
}
