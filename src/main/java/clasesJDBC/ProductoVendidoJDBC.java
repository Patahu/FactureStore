/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Producto;

import clases.ProductoVendido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class ProductoVendidoJDBC {
    private static final String SQL_INSERTAR_PRODUCTO_VENDIDO="{call insertar_ProductoVendido(?,?,?,?)}";
    private static final String SQL_INSERTAR_PRODUCTO_CONSULTAR="{call consultar_ProductoStock(?,?)}";
    
    private static final String SQL_BUSCADOR_DIAXDIA="{call productos_mas_vendidosxdia(?)}";
    
    private static final String SQL_BUSCADOR_RANGO="{call productos_mas_vendidosxrango(?,?)}";
    private static final String SQL_BUSCADOR_DIA="{call productos_x_dia()}";//SQL_BUSCADOR_DIA
    private static final String SQL_BUSCADOR_RANGO_DIA="{call productos_dia_rango(?,?)}";
    private static final String SQL_BUSCADOR_RANGO_DIA_NOMBRE="{call productos_dia_rangoxnombre(?,?,?)}";
    private static final String SQL_BUSCADOR_RANGO_DIA_NOMBRE_VENTAS="{call productos_mas_vendidosxrangoxnombre(?,?,?)}";
    private static final String SQL_BUSCADOR_DIA_NOMBRE_VENTAS="{call productos_mas_vendidosxnombre(?)}";
    private static final String SQL_BUSCADOR_DIA_NOMBRE="{call productos_dia_nombre(?)}";
    private static final String SQL_BUSCADOR_HISTORIAL_TODO="{call productos_historial_todo()}";
    private static final String SQL_BUSCADOR_HISTORIAL_RANGO="{call productos_historial_productos(?,?)}";
    private static final String SQL_BUSCADOR_HISTORIAL_RANGO_NOMBRE="{call productos_historial_productos_nombre(?,?,?)}";
     private static final String SQL_BUSCADOR_HISTORIAL_SOLO_NOMBRE="{call productos_historial_productos_solo_nombre(?)}";

    public int insertaProductoVendido(HashMap<Integer, ProductoVendido> productos,String idVenta){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        for (HashMap.Entry<Integer, ProductoVendido> entry :productos.entrySet()) {
        
            try {
                conn=  getConnection();
                stmt=conn.prepareStatement(SQL_INSERTAR_PRODUCTO_VENDIDO);
                stmt.setDouble(1, entry.getValue().getPrecioVendido());
                stmt.setInt(2, entry.getValue().getIdProducto());
                stmt.setString(3, idVenta);
                stmt.setDouble(4, entry.getValue().getCantidadVendida());
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
        }

        return registros;
    }
    public String consultar(HashMap<Integer, ProductoVendido> productos){
        Connection conn=  null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String resultado="";
        boolean registros=true;
                // iterate over HashMap entries
        for (HashMap.Entry<Integer, ProductoVendido> entry :productos.entrySet()) {
            
            try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_INSERTAR_PRODUCTO_CONSULTAR);
            stmt.setInt(1, entry.getValue().getIdProducto());
            stmt.setDouble(2, entry.getValue().getCantidadVendida());
            rs=stmt.executeQuery();
            if(rs.next()){
                int posible=rs.getInt("respuesta");
                System.out.println("id producto--"+entry.getValue().getIdProducto()+" /"+posible+ " /"+entry.getValue().getCantidadVendida());
                if(posible==0){
                    registros=false;
                    resultado+=entry.getValue().getNombre()+" STOCK insuficiente \n";
                }                 
            }
      
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
            
             

        return resultado;
    }  
    
    public ArrayList<ProductoVendido> buscarProductoxdia(Date fecha){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();

        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
  
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_DIAXDIA);
            stmt.setDate(1,sqlDate);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB(rs);
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
    public ArrayList<ProductoVendido> buscarProductoxrango(Date fecha,Date fecha1){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
        
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_RANGO);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB(rs);
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
    
    public ArrayList<ProductoVendido> buscardia(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
        
   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_DIA);
  
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
    
    public ArrayList<ProductoVendido> buscardiaRango(Date fecha,Date fecha1){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_RANGO_DIA);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
    
    public ArrayList<ProductoVendido> buscardiaRangoNombre(Date fecha,Date fecha1,String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_RANGO_DIA_NOMBRE);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            stmt.setString(3,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
    public ArrayList<ProductoVendido> buscardiaRangoNombreVentas(Date fecha,Date fecha1,String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_RANGO_DIA_NOMBRE_VENTAS);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            stmt.setString(3,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB(rs);
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
    
       public ArrayList<ProductoVendido> buscardiaNombreVentas(String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
    
   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_DIA_NOMBRE_VENTAS);
     
            stmt.setString(1,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB(rs);
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
    
    
    
    public ArrayList<ProductoVendido> buscardiaNombre(String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();

   
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_DIA_NOMBRE);

            stmt.setString(1,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
    public ArrayList<ProductoVendido> buscarHistorialProductoTodo(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();

        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_HISTORIAL_TODO);

            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
    public ArrayList<ProductoVendido> buscarHistorialProductoRango(Date fecha,Date fecha1){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_HISTORIAL_RANGO);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
     public ArrayList<ProductoVendido> buscarHistorialProductoRangoNombre(Date fecha,Date fecha1,String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_HISTORIAL_RANGO_NOMBRE);
            stmt.setDate(1,sqlDate);
            stmt.setDate(2,sqlDate1);
            stmt.setString(3,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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
  
     
      public ArrayList<ProductoVendido> buscarHistorialProductoSoloNombre(String nombre){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<ProductoVendido> listaProductos= new ArrayList<ProductoVendido>();
               
 
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_HISTORIAL_SOLO_NOMBRE);

            stmt.setString(1,nombre);
            rs=stmt.executeQuery();
            while(rs.next()){
                ProductoVendido productoC= ProductoVendido.productoFROMDB2(rs);
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

