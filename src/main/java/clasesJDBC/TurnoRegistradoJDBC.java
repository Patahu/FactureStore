/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.TurnoRegistrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class TurnoRegistradoJDBC {
    
    private static final String SQL_BUSCAR_TURNOSREGISTRADOS="{call buscar_TurnosRegistrados}";
    private static final String SQL_BUSCAR_TODOS_TURNOS="SELECT idTurnoRegistrado,idUsuario,idHorario,fechaRealizada,horarioEntrada,horarioSalida,totalCierre,idCaja,isClose,totalEntrada FROM TurnoRegistrado WHERE isClose=0";
    private static final String SQL_BUSCAR_INGRESARTURNO="{call ingresar_TurnoRegistrado(?,?,?,?)}";

    private static final String SQL_CERRA_TURNOREGISTRADO="UPDATE [dbo].[TurnoRegistrado] SET [horarioSalida] = GETDATE(),[totalCierre] = ?,[isClose] = 1 WHERE idTurnoRegistrado=?";
    public ArrayList<TurnoRegistrado> buscarTurnosTodos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<TurnoRegistrado> turnosRegistrados=new ArrayList<>();

        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_TURNOSREGISTRADOS);
            rs=stmt.executeQuery();
     
            while(rs.next()){

                String idTurnoRegistrado=rs.getString("idTurnoRegistrado");
                int idUsuario= rs.getInt("idUsuario");
                int idHorario= rs.getInt("idHorario");
                Date fechaRealizada=rs.getDate("fechaRealizada");
                Date horarioEntrada=rs.getDate("horarioEntrada");
                Date horarioSalida=rs.getDate("horarioSalida");
                Double totalCierre=rs.getDouble("totalCierre");
                Double totalEntrada=rs.getDouble("totalEntrada");
                String idCaja=rs.getString("idCaja");
                boolean isClose=rs.getBoolean("isClose");
                int existe=rs.getInt("existe");
      
               
                turnosRegistrados.add(new TurnoRegistrado(idTurnoRegistrado,
                        idUsuario,idHorario,fechaRealizada,
                        horarioEntrada,horarioSalida,totalCierre,
                        idCaja,isClose,totalEntrada,existe));
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
        
        

        return turnosRegistrados;
    } 
    
    
    public ArrayList<TurnoRegistrado> buscarTurnosTodosUsuario(int idUsuarioBuscado, boolean isCerrado){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<TurnoRegistrado> turnosRegistrados=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_TURNOSREGISTRADOS);
            stmt.setInt(1,idUsuarioBuscado);
            stmt.setBoolean(2,isCerrado);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                int existe=rs.getInt("existe");
                if(existe==0){
                    String idTurnoRegistrado=rs.getString("idTurnoRegistrado");
                    int idUsuario= rs.getInt("idUsuario");
                    int idHorario= rs.getInt("idHorario");
                    Date fechaRealizada=rs.getDate("fechaRealizada");
                    Date horarioEntrada=rs.getDate("horarioEntrada");
                    Date horarioSalida=rs.getDate("horarioSalida");
                    Double totalCierre=rs.getDouble("totalCierre");
                    Double totalEntrada=rs.getDouble("totalEntrada");
                    String idCaja=rs.getString("idCaja");
                    boolean isClose=rs.getBoolean("isClose");
                    turnosRegistrados.add(new TurnoRegistrado(idTurnoRegistrado,
                            idUsuario,idHorario,fechaRealizada,
                            horarioEntrada,horarioSalida,totalCierre,idCaja,isClose,totalEntrada));
            
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
        
        

        return turnosRegistrados;
    }
    
    
    public int cierreTurnoRegistrado(Double totalCierre,String idTurnoR){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_CERRA_TURNOREGISTRADO);
            stmt.setDouble(1, totalCierre);
            stmt.setString(2, idTurnoR);
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
    
    public int insertarTurnoRegistrado(TurnoRegistrado turnoRegistrado){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_INGRESARTURNO);
            stmt.setInt(1, turnoRegistrado.getIdUsuario());
            stmt.setInt(2, turnoRegistrado.getIdHorario());
            stmt.setString(3, turnoRegistrado.getIdCaja());
            stmt.setDouble(4, turnoRegistrado.getTotalCierre());
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
}
