/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Producto;
import clases.Usuario;
import clases.Venta;
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
public class VentaJDBC {
      private static final String SQL_INSERTAR_VENTA="{call insertar_Venta(?,?,?,?,?)}";
      private static final String SQL_BUSCAR_VENTA="{call buscar_buscar_ventas_todos()}";
      private static final String SQL_BUSCAR_VENTA_NOMBRE="{call buscar_buscar_ventas_nombre(?)}";
      private static final String SQL_BUSCAR_VENTA_NOMBRE_RANGO="{call buscar_buscar_ventas_rango_nombre(?,?,?)}";
      private static final String SQL_BUSCAR_VENTA_RANGO="{call buscar_buscar_ventas_rango(?,?)}";
      public int insertarVenta(Venta ventaIngresar){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_INSERTAR_VENTA);
            stmt.setString(1, ventaIngresar.getIdVenta());
            stmt.setDouble(2, ventaIngresar.getPrecioTotal());
            stmt.setDouble(3, ventaIngresar.getDescuento());
            stmt.setString(4, ventaIngresar.getIdCaja());
            stmt.setInt(5, ventaIngresar.getIdUsuario());
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
    public ArrayList<Venta> buscarVentas(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Venta> listaProductos= new ArrayList<Venta>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_VENTA);

            rs=stmt.executeQuery();
            while(rs.next()){
                Venta productoC= Venta.ventaFromDB1(rs);
                listaProductos.add(productoC);                    
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

        return listaProductos;
    }
    
    public ArrayList<Venta> buscarVentasNombre(String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Venta> listaProductos= new ArrayList<Venta>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_VENTA_NOMBRE);
            stmt.setString(1, nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                Venta productoC= Venta.ventaFromDB1(rs);
                listaProductos.add(productoC);                    
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

        return listaProductos;
    }
     public ArrayList<Venta> buscarVentasNombreRango(String nombre,Date fecha,Date fecha1){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Venta> listaProductos= new ArrayList<Venta>();
                
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
        
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_VENTA_NOMBRE_RANGO);
            stmt.setString(1, nombre);
            stmt.setDate(2, sqlDate);
            stmt.setDate(3, sqlDate1);
            rs=stmt.executeQuery();
            while(rs.next()){
                Venta productoC= Venta.ventaFromDB1(rs);
                listaProductos.add(productoC);                    
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

        return listaProductos;
    }
    public ArrayList<Venta> buscarVentasRango(Date fecha,Date fecha1){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Venta> listaProductos= new ArrayList<Venta>();
                
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
        
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_VENTA_RANGO);
            stmt.setDate(1, sqlDate);
            stmt.setDate(2, sqlDate1);
            rs=stmt.executeQuery();
            while(rs.next()){
                Venta productoC= Venta.ventaFromDB1(rs);
                listaProductos.add(productoC);                    
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

        return listaProductos;
    }
}
