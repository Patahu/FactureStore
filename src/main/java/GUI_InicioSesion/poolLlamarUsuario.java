/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_InicioSesion;

import clases.Usuario;
import clasesJDBC.UsuarioJDBC;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolLlamarUsuario implements Callable<String>{
    private Usuario usuario;
    private ControladorInicioSesion controladorInicioSesion;
    public poolLlamarUsuario(ControladorInicioSesion controladorInicioSesion,Usuario usuario) {
        this.controladorInicioSesion=controladorInicioSesion;
        this.usuario=usuario;
    }
    
    

    @Override
    public String call() throws Exception {
        UsuarioJDBC usuarioJDBC=new UsuarioJDBC();
        EstadoInicioSesion estado=usuarioJDBC.validar(this.usuario);
        controladorInicioSesion.continuar(estado);
        return "poolLlamarUsuario completado";
    }
    
}
