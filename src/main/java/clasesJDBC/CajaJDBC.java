/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Caja;
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
public class CajaJDBC {
    
    private static final String SQL_BUSCAR_CAJA="{call buscar_caja}";
    private static final String SQL_INICIAR_CAJA="INSERT INTO [dbo].[Caja]([idCaja],[inicioCaja],[cierreCaja],[fechaCreacion],[idUsuario],[fechaCierre],[isClose]) VALUES(?,?,?,GETDATE(),?,null,0)";
    private static final String SQL_CERRAR_CAJA="{call cerrar_caja(?)}";
    private static final String SQL_ACTUALIZAR_CAJA="UPDATE [dbo].[Caja] SET [cierreCaja] =? WHERE idCaja =?";
    public Caja CajasAbiertas(){
        
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Caja cajanueva=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_CAJA);
            rs=stmt.executeQuery();
            while(rs.next()){
                String idCaja=rs.getString("idCaja");
                float inicioCaja= rs.getFloat("inicioCaja");
                double cierreCaja=Double.valueOf(String.format("%.2f",rs.getFloat("cierreCaja")));
                Date fechaCreacion=rs.getDate("fechaCreacion");
                int idUsuario=rs.getInt("idUsuario");
                int isClose=rs.getInt("isClose");
                cajanueva=new Caja(idCaja,idUsuario,inicioCaja, cierreCaja,fechaCreacion,isClose);

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

        return cajanueva;
    
    }
    public int insertarCaja(Caja caja){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_INICIAR_CAJA);
            stmt.setString(1, caja.getIdCaja());
            stmt.setDouble(2, caja.getInicioCaja());
            stmt.setDouble(3, caja.getInicioCaja());
            stmt.setInt(4, caja.getIdUsuarioCaja());
 
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
    public int cerrarCaja(String idCaja){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_CERRAR_CAJA);
            stmt.setString(1, idCaja);
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
    
    
    public void ingresarAumentoPorVenta(Double cierre,String idCaja){
        Connection conn=  null;
        PreparedStatement stmt=null;
    
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_ACTUALIZAR_CAJA);
            stmt.setDouble(1, cierre);
            stmt.setString(2, idCaja);
            stmt.executeUpdate();
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
      
    }
}
