/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

import clases.Usuario;
import clasesJDBC.UsuarioJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolEliminarUsuarios implements Callable<String> {
       private ControladorUsuarios controladoUsuarios;
    public poolEliminarUsuarios(ControladorUsuarios controladoUsuarios) {
        this.controladoUsuarios=controladoUsuarios;
    }
    
    @Override
    public String call() throws Exception {
        UsuarioJDBC usuarioJDBC= new UsuarioJDBC();
    
        int resultados=usuarioJDBC.eliminarUsuario(controladoUsuarios.getUsuario().getIdUsuario());
        if(resultados==1){
              JOptionPane.showMessageDialog(null, "Se ha eliminado el Usuario");
               controladoUsuarios.proceso("Buscar");
           
        }

        return "poolIngresarHorario Terminado";
    } 
}
