/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.entrada;

import clases.Caja;
import clases.Horario;
import clases.Usuario;
import clasesJDBC.CajaJDBC;
import clasesJDBC.HorarioJDBC;
import clasesJDBC.UsuarioJDBC;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarCaja implements Callable<String>{

    private ControladorGestionarTienda controladorEntrada;
    public poolBuscarCaja(ControladorGestionarTienda controladorEntrada) {
 
        this.controladorEntrada=controladorEntrada;
    }
    
    @Override
    public String call() throws Exception {
        
        CajaJDBC cahjaJDBC= new CajaJDBC();
        Caja caja= cahjaJDBC.CajasAbiertas();
        if(caja!=null){
            UsuarioJDBC usuarioIniciar= new UsuarioJDBC();
            Usuario usuarioCreado= usuarioIniciar.buscarUsuario(new Usuario(caja.getIdUsuarioCaja()));
            this.controladorEntrada.setCaja(caja, usuarioCreado);
            this.controladorEntrada.bucle(2);
        }else{
            this.controladorEntrada.setCaja(null, null);  
        }
        return "poolEntrada terminado";
    }
    
}
