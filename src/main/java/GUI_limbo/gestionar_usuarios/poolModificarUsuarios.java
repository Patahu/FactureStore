/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

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

public class poolModificarUsuarios implements Callable<String>{
    private ControladorUsuarios controladorUsuarios;
    private String stringNombreHorario;
    public poolModificarUsuarios(ControladorUsuarios controladorUsuarios,String stringNombreHorario) {
        this.controladorUsuarios=controladorUsuarios;
        this.stringNombreHorario=stringNombreHorario;
    }
    
    @Override
    public String call() throws Exception {
        UsuarioJDBC usuarioJDBC= new UsuarioJDBC();
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        
        Horario horarioNuevo=horarioJDBC.buscarHorariosNombre(stringNombreHorario);
        int isAdmin=0;
        int isActivo=0;
        
        if(controladorUsuarios.modificarUsuarios.rol.getSelectedItem().equals("Administrador")){
            isAdmin=1;
        
        }
        if(controladorUsuarios.modificarUsuarios.comboActivo.getSelectedItem().equals("SI")){
            isActivo=1;
        }
        Usuario usuario=new Usuario(controladorUsuarios.getUsuario().getIdUsuario(),controladorUsuarios.modificarUsuarios.nombreUsuario.getText(), new String(controladorUsuarios.modificarUsuarios.contraseña.getPassword()),isActivo,isAdmin,horarioNuevo.getIdHorario());

        usuarioJDBC.modificarHorario(usuario);
        
        JOptionPane.showMessageDialog(null, "Se ha modificado un nuevo usuario");
        controladorUsuarios.proceso("Cancelar");
        return "poolIngresarUsuario Terminado";
    } 
}  

