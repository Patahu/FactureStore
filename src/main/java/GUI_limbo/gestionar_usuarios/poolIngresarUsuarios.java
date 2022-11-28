/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

import GUI_limbo.gestionar_horarios.ControladorHorarios;
import clases.Horario;
import clases.Usuario;
import clasesJDBC.HorarioJDBC;
import clasesJDBC.UsuarioJDBC;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;

/**
 *
 * @author fell
 */
public class poolIngresarUsuarios implements Callable<String>{
    private ControladorUsuarios controladorUsuarios;
    private String stringNombreHorario;
    public poolIngresarUsuarios(ControladorUsuarios controladorUsuarios,String stringNombreHorario) {
        this.controladorUsuarios=controladorUsuarios;
        this.stringNombreHorario=stringNombreHorario;
    }
    
    @Override
    public String call() throws Exception {
        UsuarioJDBC usuarioJDBC= new UsuarioJDBC();
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        Horario horarioNuevo=horarioJDBC.buscarHorariosNombre(stringNombreHorario);
        Usuario usuario=new Usuario(controladorUsuarios.ingresarUsuario.nombreUsuario.getText(), new String(controladorUsuarios.ingresarUsuario.contraseña.getPassword()),1,horarioNuevo.getIdHorario());
        usuarioJDBC.insertarUsuario(usuario);
        JOptionPane.showMessageDialog(null, "Se ha ingresado un nuevo usuario");
        return "poolIngresarUsuario Terminado";
    }
    
    
}
