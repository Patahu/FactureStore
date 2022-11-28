/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import GUI_InicioSesion.EstadoInicioSesion;
import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class UsuarioJDBC {
    private static final String SQL_VALIDAR_USUARIO="{call buscar_usuario(?,?)}";
    private static final String SQL_BUSCADOR_USUARIO="SELECT [idUsuario],[nombre] FROM [dbAnden].[dbo].[Usuario] WHERE idUsuario=?;";
    private static final String SQL_BUSCAR_HORARIOS_ACTIVOS="SELECT [idUsuario],[nombre],[password],[isActive],[isAdmin],[fechaCreacion],[idHorario] FROM [dbAnden].[dbo].[Usuario] WHERE isActive=1";
    private static final String SQL_BUSCAR_HORARIOS_INACTIVOS="SELECT [idUsuario],[nombre],[password],[isActive],[isAdmin],[fechaCreacion],[idHorario] FROM [dbAnden].[dbo].[Usuario] WHERE isActive=0";
    
    private static final String SQL_ELIMINAR_USUARIO="DELETE FROM [dbo].[Usuario] WHERE idUsuario=?";

    private static final String SQL_INSERTAR_USUARIO="INSERT INTO [dbo].[Usuario]([nombre],[password],[isActive],[isAdmin],[fechaCreacion],[idHorario]) VALUES(?,?,1,?,GETDATE(),?)";
    
    private static final String SQL_MODIFICAR_HORARIO="UPDATE [dbo].[Usuario] SET [nombre] = ?,[password] =?,[isActive] = ?,[isAdmin] = ?,[idHorario] = ? WHERE idUsuario=?";
    public UsuarioJDBC() {
    }

    // valida si el usuario esta registrado
    public EstadoInicioSesion validar(Usuario usuarioIngresado){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        EstadoInicioSesion estadoInicioSesion=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_VALIDAR_USUARIO);
            stmt.setString(1,usuarioIngresado.getNombreUsuario());
            stmt.setString(2,usuarioIngresado.getPasswordUsuario());
            rs=stmt.executeQuery();
            if(rs.next()){
                int respuesta=rs.getInt("respuesta");
                // la respuesta sera de 0 o 1, si es 0 es que no a encontrado ningun usuario registrado y si es 1, lo contrario.
                if(respuesta==1){
                    int idUsuario=rs.getInt("idUsuario");
                    String nombreUsuario= rs.getString("nombre");
                    byte isActive=rs.getByte("isActive");
                    byte isAdmin=rs.getByte("isAdmin");
                    Date fechaCreacion=rs.getDate("fechaCreacion");
                    int idHorario=rs.getInt("idHorario");
                    Usuario usuarioBuscado=new Usuario(idUsuario,nombreUsuario, 
                            isActive,isAdmin,fechaCreacion,idHorario);
                    estadoInicioSesion=new EstadoInicioSesion(usuarioBuscado,
                            "completo","encontrado"); // se envia un estado de inicio, si encuentra entonces se puede iniciar sesion
                    
                }else{
                    estadoInicioSesion= new EstadoInicioSesion("completo","no encontrado");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);  
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }

        return estadoInicioSesion;
    }
    // BUSCA A UN USUARIO
    public Usuario buscarUsuario(Usuario usuarioIngresado){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuarioNuevo=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_USUARIO);
            stmt.setInt(1,usuarioIngresado.getIdUsuario());

            rs=stmt.executeQuery();
            if(rs.next()){
                int idUsuario= rs.getInt("idUsuario");
                String nombreUsuario= rs.getString("nombre");

                usuarioNuevo=new Usuario(idUsuario,nombreUsuario);                    
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);  
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }

        return usuarioNuevo;
    }
    
    public ArrayList<Usuario> buscarUsuariosActivos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Usuario> usuarios=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIOS_ACTIVOS);

            rs=stmt.executeQuery();
            while(rs.next()){
                //SELECT [idUsuario],[nombre],[isActive],[isAdmin],[fechaCreacion],[idHorario] FROM [dbAnden].[dbo].[Horario] WHERE isActivo=1
                int idUsuario=rs.getInt("idUsuario");
                byte isAdmin=rs.getByte("isAdmin");
                int idHorario=rs.getInt("idHorario");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombreUsuario=rs.getString("nombre");
                String contraseña=rs.getString("password");
                byte isActive=rs.getByte("isActive");
    
                usuarios.add(new Usuario(idUsuario,nombreUsuario,contraseña, 
                        isActive,isAdmin,fechaCreacion,idHorario));

            }
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);  
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        

        return usuarios;
    }    
    
    

    public ArrayList<Usuario> buscarUsuariosInactivos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Usuario> usuarios=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIOS_INACTIVOS);

            rs=stmt.executeQuery();
            while(rs.next()){

                int idUsuario=rs.getInt("idUsuario");
                int isAdmin=rs.getInt("isAdmin");
                int idHorario=rs.getInt("idHorario");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombreUsuario=rs.getString("nombre");
                String contraseña=rs.getString("password");
                int isActive=rs.getInt("isActive");
                usuarios.add(new Usuario(idUsuario,nombreUsuario,contraseña, 
                        isActive,isAdmin,fechaCreacion,idHorario));

            }
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);  
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }
        }
        
        

        return usuarios;
    }  
    
    public int insertarUsuario(Usuario usuario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_INSERTAR_USUARIO);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getPasswordUsuario());
            stmt.setInt(3, usuario.getIsAdmin());
            stmt.setInt(4, usuario.getIdHorario());
            stmt.executeUpdate();
            registros+=1;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }    

    public int modificarHorario(Usuario usuario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        
        int registros=0;
        try {
            //[nombre] = ?,[password] =?,[isActive] = ?,[isAdmin] = ?,[idHorario] = ? WHERE idUsuario=?
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_MODIFICAR_HORARIO);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getPasswordUsuario());
            stmt.setInt(3, usuario.getIsActive());
            stmt.setInt(4, usuario.getIsAdmin());
            stmt.setInt(5, usuario.getIdHorario());
            stmt.setInt(6, usuario.getIdUsuario());
            stmt.executeUpdate();
            registros+=1;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", 
                    JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
    
     public int eliminarUsuario(int idUsuario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_ELIMINAR_USUARIO);
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            registros+=1;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", 
                    JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
    
}
