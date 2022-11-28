/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class HorarioJDBC {
    private static final String SQL_BUSCAR_HORARIO="SELECT [idHorario],[horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo] FROM [dbAnden].[dbo].[Horario] WHERE idHorario=?";
    private static final String SQL_BUSCAR_HORARIOS_ACTIVOS="SELECT [idHorario],[horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo] FROM [dbAnden].[dbo].[Horario] WHERE isActivo=1";
    private static final String SQL_BUSCAR_HORARIOS_TODOS="SELECT [idHorario],[horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo] FROM [dbAnden].[dbo].[Horario]";
    private static final String SQL_BUSCAR_HORARIOS_INACTIVOS="SELECT [idHorario],[horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo] FROM [dbAnden].[dbo].[Horario] WHERE isActivo=0";

    private static final String SQL_BUSCAR_HORARIO_ID="SELECT [idHorario],[horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo] FROM [dbAnden].[dbo].[Horario] WHERE idHorario=?";
    
    private static final String SQL_BUSCAR_HORARIO_NOMBRE="SELECT [idHorario] FROM [dbAnden].[dbo].[Horario] WHERE nombre=?";
    private static final String SQL_INSERTAR_HORARIO="INSERT INTO [dbo].[Horario]([horaEntrada],[horaSalida],[fechaCreacion],[nombre],[isActivo]) VALUES (?,?,GETDATE(),?,1)";
    private static final String SQL_ELIMINAR_HORARIO="DELETE FROM [dbo].[Horario] WHERE idHorario=?";
    
    private static final String SQL_MODIFICAR_HORARIO="UPDATE [dbo].[Horario] SET [nombre] =?,[isActivo] =?,[horaEntrada] =?,[horaSalida] = ? WHERE idHorario=?;";
    // valida si el usuario esta registrado
    public Horario buscarHorario(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Horario nuevoHorario=new Horario();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIO);
            stmt.setInt(1,id);

            rs=stmt.executeQuery();
            if(rs.next()){

                int idHorario=rs.getInt("idHorario");
                Date horaEntrada= rs.getTimestamp("horaEntrada");
                Date horaSalida=rs.getTimestamp("horaSalida");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombre=rs.getString("nombre");
                int isActive=rs.getInt("isActivo");
                nuevoHorario=new Horario(idHorario,horaEntrada,
                        horaSalida,fechaCreacion,nombre,isActive);
                    
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

        return nuevoHorario;
    }
    
    public Horario buscarHorariosId(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Horario horario=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIO_ID);
            stmt.setInt(1,id);
            rs=stmt.executeQuery();
            while(rs.next()){

                int idHorario=rs.getInt("idHorario");
                Date horaEntrada= rs.getTimestamp("horaEntrada");
                Date horaSalida=rs.getTimestamp("horaSalida");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombre=rs.getString("nombre");
                int isActive=rs.getInt("isActivo");
                horario=new Horario(idHorario,horaEntrada, 
                        horaSalida,fechaCreacion,nombre,isActive);

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
        
        

        return horario;
    }  
    
    public Horario buscarHorariosNombre(String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Horario horario=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIO_NOMBRE);
            stmt.setString(1,nombre);
            rs=stmt.executeQuery();
            if(rs.next()){
                
                int idHorario=rs.getInt("idHorario");
   
                horario=new Horario(idHorario);

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
        
        

        return horario;
    } 
    
    
    
 
    public ArrayList<Horario> buscarHorariosActivos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Horario> horarios=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIOS_ACTIVOS);

            rs=stmt.executeQuery();
            while(rs.next()){

                int idHorario=rs.getInt("idHorario");
                Date horaEntrada=rs.getTimestamp("horaEntrada");
                Date horaSalida=rs.getTimestamp("horaSalida");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombre=rs.getString("nombre");
                int isActive=rs.getInt("isActivo");
    
                horarios.add(new Horario(idHorario,horaEntrada, 
                        horaSalida,fechaCreacion,nombre,isActive));

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
        
        

        return horarios;
    }    
    
    
 
    public ArrayList<Horario> buscarHorariosInactivos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Horario> horarios=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIOS_INACTIVOS);

            rs=stmt.executeQuery();
            while(rs.next()){

                int idHorario=rs.getInt("idHorario");
                Date horaEntrada= rs.getTimestamp("horaEntrada");
                Date horaSalida=rs.getTimestamp("horaSalida");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                String nombre=rs.getString("nombre");
                int isActive=rs.getInt("isActivo");
    
                horarios.add(new Horario(idHorario,horaEntrada,
                        horaSalida,fechaCreacion,nombre,isActive));

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
        
        

        return horarios;
    }  
    public ArrayList<Horario> buscarHorariosTodos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Horario> horarios=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_HORARIOS_TODOS);

            rs=stmt.executeQuery();
            while(rs.next()){

                int idHorario=rs.getInt("idHorario");
                Date horaEntrada= rs.getTimestamp("horaEntrada");
                Date horaSalida=rs.getTimestamp("horaSalida");
                Date fechaCreacion=rs.getTimestamp("fechaCreacion");
                String nombre=rs.getString("nombre");
                int isActive=rs.getInt("isActivo");
    
                horarios.add(new Horario(idHorario,horaEntrada, 
                        horaSalida,fechaCreacion,nombre,isActive));

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
        
        

        return horarios;
    }
    

    
    public int insertarHorario(Horario horario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm");  
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");  
        
        String entrada = dateFormat1.format( horario.getHoraEntrada().getTime());
        String salida = dateFormat2.format(horario.getHoraSalida().getTime());
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_INSERTAR_HORARIO);
            stmt.setString(1, entrada);
            stmt.setString(2, salida);
            stmt.setString(3, horario.getNombre());
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
    public int eliminarHorario(Horario horario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_ELIMINAR_HORARIO);
            stmt.setInt(1, horario.getIdHorario());
            stmt.executeUpdate();
            registros+=1;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
    public int modificarHorario(Horario horario){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm");  
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");  
        
        String entrada = dateFormat1.format( horario.getHoraEntrada().getTime());
        String salida = dateFormat2.format(horario.getHoraSalida().getTime());
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_MODIFICAR_HORARIO);
            stmt.setString(1, horario.getNombre());
            stmt.setInt(2, horario.getIsActive());
            stmt.setString(3, entrada);
            stmt.setString(4, salida);
            stmt.setInt(5, horario.getIdHorario());
            
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
