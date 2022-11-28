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
public class poolCrearCaja implements Callable<String> {
    private Usuario usuario;
    private ControladorGestionarTienda controladorEntrada;
    public poolCrearCaja(ControladorGestionarTienda controladorEntrada,Usuario usuario) {
        this.usuario=usuario;
        this.controladorEntrada=controladorEntrada;
        
    }
    
    @Override
    public String call() throws Exception {
        CajaJDBC caja= new CajaJDBC();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
        String strDate = dateFormat.format(date);
        double number = Double.parseDouble(controladorEntrada.getEntrada().cantidadInicial.getText());
        caja.insertarCaja(new Caja(strDate,usuario.getIdUsuario(),number,number));
        this.controladorEntrada.setCaja(new Caja(number,number,date),usuario);
        this.controladorEntrada.bucle(1);
        JOptionPane.showMessageDialog(null, "CAJA INICIADA");
        return "poolCrearCaja completado";
    }
    
}
