/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Producto;
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
public class ProductoJDBC {

    private static final String SQL_BUSCADOR_PRODUCTO="{call buscar_productoInicio}";
    private static final String SQL_INSERTAR_PRODUCTO="{call insertar_Producto(?,?,?,?,?,?,?,?)}";
    private static final String SQL_MODIFY_PRODUCTO="{call modify_Producto(?,?)}";
 
    private static final String SQL_BUSCAR_PRODUCTO_NOMBRE="{call buscar_productoNombre(?)}";
    private static final String SQL_BUSCAR_PRODUCTO_NOMBRE_CATEGORIA="{call buscar_productoNombrexcategoria(?,?)}";
    private static final String SQL_ELIMINAR_PRODUCTO="DELETE FROM [dbo].[Producto] WHERE idProducto= ?";
    private static final String SQL_PRODUCTO_BARRAS="{call buscar_codigoBarrasBuscar(?)}";
    private static final String SQL_PRODUCTO_VENDIDO="{call buscar_productoVendidoModificar(?)}";
    private static final String SQL_DELETE_ALL="{call delete_ventaProductos(?)}";
    // BUSCA A UN USUARIO
    public ArrayList<Producto> buscarProductos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Producto> listaProductos= new ArrayList<Producto>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_PRODUCTO);

            rs=stmt.executeQuery();
            while(rs.next()){
                Producto productoC= Producto.productoFROMDB(rs);
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
     public ArrayList<Producto> buscarProductosVendidos(String idVenta){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Producto> listaProductos= new ArrayList<Producto>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_PRODUCTO_VENDIDO);
            stmt.setString(1, idVenta);
            rs=stmt.executeQuery();
            while(rs.next()){
                Producto productoC= Producto.productoFROMDB(rs);
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
    public int deleteAll(String idVenta){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_DELETE_ALL);
            stmt.setString(1, idVenta);
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
    public ArrayList<Producto> buscarProductosNombre(String nombreBus){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Producto> listaProductos= new ArrayList<Producto>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_PRODUCTO_NOMBRE);
            stmt.setString(1, nombreBus);
            rs=stmt.executeQuery();
            while(rs.next()){
                Producto productoC= Producto.productoFROMDB(rs);

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
    
    public ArrayList<Producto> buscarProductosNombreCategoria(String nombreBus,String categoria){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Producto> listaProductos= new ArrayList<Producto>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_PRODUCTO_NOMBRE_CATEGORIA);
            stmt.setString(1, nombreBus);
            stmt.setString(2, categoria);
            rs=stmt.executeQuery();
            while(rs.next()){
                Producto productoC= Producto.productoFROMDB(rs);

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
    public Producto buscarProductoBarra(String codigoBarra){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Producto productoC=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_PRODUCTO_BARRAS);
            stmt.setString(1, codigoBarra);
            rs=stmt.executeQuery();
            while(rs.next()){
                productoC= Producto.productoFROMDB(rs);
                
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

        return productoC;
    }  
    public int insertaProducto(Producto producto){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
           
            stmt=conn.prepareStatement(SQL_INSERTAR_PRODUCTO);
            stmt.setString(1, producto.getCodigoBarras());
            stmt.setDouble(2, producto.getPrecioEntrada());
            stmt.setDouble(3, producto.getPrecioSalida());
            stmt.setString(4, producto.getUnidad());
            stmt.setInt(5, producto.getIdCategoria());
            stmt.setString(6, producto.getNombre());
            stmt.setDouble(7, producto.getCantidad());
            stmt.setDouble(8, producto.getCantidadMinima());
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
      public int insertaProductoModificarCantidad(String codigoBarras,double cantidad){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
           
            stmt=conn.prepareStatement(SQL_MODIFY_PRODUCTO);
            stmt.setString(1, codigoBarras);
            stmt.setDouble(2, cantidad);

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
    public int eliminaProducto(int idProducto){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_ELIMINAR_PRODUCTO);
            stmt.setInt(1, idProducto);
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
