/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Horario;
import clases.OperacioCaja;
import clases.OperacionProducto;
import clases.Producto;
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
public class OperacionCajaJDBC {
    private static final String SQL_OPERACION_CAJA="{call consultar_ingresarOperacion(?,?,?,?,?)}";
    private static final String SQL_OPERACION_BUSCAR_NOMBRE="{call buscar_productoOperacionNombre(?)}";
    private static final String SQL_OPERACION_BUSCAR_TODO="SELECT [idOperacion],[nombreUsuario],[tipo],[fechaOperacion],[precioTotal],[idCaja],[razon] FROM [dbo].[OperacionCaja]";
    public int insertaOperacionProducto(String IdOperacionCaja,String NombreUsuario, String Tipo,double PrecioTotal,String Razon){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
           
            stmt=conn.prepareStatement(SQL_OPERACION_CAJA);
            stmt.setString(1, IdOperacionCaja);
            stmt.setString(2, NombreUsuario);
            stmt.setString(3, Tipo);
            stmt.setDouble(4, PrecioTotal);
            stmt.setString(5, Razon);
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
    public ArrayList<OperacioCaja> buscaroperacioCajaId(String id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<OperacioCaja> operacioCaja=new ArrayList<OperacioCaja>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_OPERACION_BUSCAR_NOMBRE);
            stmt.setString(1,id);
            rs=stmt.executeQuery();
            System.out.println("AQUI----------"+id);
            while(rs.next()){
                OperacioCaja opera=OperacioCaja.operacionFROMDB(rs);
                operacioCaja.add(opera);
                    
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

        return operacioCaja;
    }
    public ArrayList<OperacioCaja> buscarOperacionCaja(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<OperacioCaja> listaOperaciones= new ArrayList<OperacioCaja>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_OPERACION_BUSCAR_TODO);
            rs=stmt.executeQuery();
            while(rs.next()){
                OperacioCaja operacioCaja=OperacioCaja.operacionFROMDB(rs);
                listaOperaciones.add(operacioCaja);                    
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

        return listaOperaciones;
    }
}
