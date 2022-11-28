/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.Caja;
import clases.Usuario;
import clasesJDBC.CajaJDBC;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolCerrarCaja implements Callable<String> {
    private Usuario usuario;
    private ControladorGestionarTienda controladorEntrada;
    public poolCerrarCaja(ControladorGestionarTienda controladorEntrada,Usuario usuario) {
        this.usuario=usuario;
        this.controladorEntrada=controladorEntrada;
        
    }
    
    @Override
    public String call() throws Exception {
        CajaJDBC caja= new CajaJDBC();
        caja.cerrarCaja(this.controladorEntrada.getCaja().getIdCaja());
        this.controladorEntrada.bucle(1);
        JOptionPane.showMessageDialog(null, "CAJA CERRADA");
        return "poolCerrarCaja completado";
    }
    
}
