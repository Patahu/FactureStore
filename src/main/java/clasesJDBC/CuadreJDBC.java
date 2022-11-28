/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Cuadre;
import clases.OperacioCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class CuadreJDBC {
    private static final String SQL_CUADRE="{call ventas_cierre}";
    private static final String SQL_PRODUCTO_VENTAS="{call ventas_producto(?)}";
    public ArrayList<Cuadre> buscarOperacionCaja(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Cuadre> listaOperaciones= new ArrayList<Cuadre>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_CUADRE);
            rs=stmt.executeQuery();
            while(rs.next()){
                Cuadre cuadre=Cuadre.productoFROMDB(rs);
                listaOperaciones.add(cuadre);                    
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
    public ArrayList<Cuadre> buscarProductosVentas(String idVenta){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Cuadre> listaOperaciones= new ArrayList<Cuadre>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_PRODUCTO_VENTAS);
            stmt.setString(1,idVenta);
            rs=stmt.executeQuery();
            while(rs.next()){
                Cuadre cuadre=Cuadre.productoFROMDB(rs);
                listaOperaciones.add(cuadre);                    
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
