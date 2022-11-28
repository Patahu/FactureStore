/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.Usuario;
import clasesJDBC.TurnoRegistradoJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolCerrarTurnoRegistrado implements Callable<String>{
    private ControladorGestionarTienda controladorEntrada;
    private Usuario usuario;
    public poolCerrarTurnoRegistrado(ControladorGestionarTienda controladorEntrada,Usuario usuario) {
        this.controladorEntrada=controladorEntrada;
        this.usuario=usuario;
    }
    
    @Override
    public String call() throws Exception {

        TurnoRegistradoJDBC turnoRegistradoJDBC=new TurnoRegistradoJDBC();
        turnoRegistradoJDBC.cierreTurnoRegistrado(this.controladorEntrada.getCaja().getCierreCaja(),this.controladorEntrada.getTurnoRegistrado().getIdTurnoRegistrado());
        this.controladorEntrada.bucle(2);
        JOptionPane.showMessageDialog(null, "SE A CERRADO EL TURNO");   
        return "poolEntrada terminado";
    }   
}
