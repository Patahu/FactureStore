/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.OperacionProducto;
import clases.Producto;
import clases.ProductoVendido;
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
public class OperacionProductoJDBC {
    private static final String SQL_FACTURA_BOLETA="{call ingresar_operacion_producto(?,?,?,?,?)}";
    private static final String SQL_FACTURA_BOLETA_PRODUCTO="{call ingresar_operacion_productoxproducto(?,?,?,?,?)}";
    private static final String SQL_FACTURA_BOLETA_BUSAR="SELECT [idOperacionProducto]" +
    ",[fechaCreacion]" +
    ",[idUsuario]" +
    ",[idOperacion]" +
    ",[numeroSerie]" +
    ",[precioTotal]" +
    ",[tipo]" +
    "FROM [dbo].[OperacionProducto]";
    private static final String SQL_FACTURA_BOLETAOPERACION="{call buscar_productoFactura(?)}";
    public OperacionProductoJDBC() {
    }
    public ArrayList<OperacionProducto> buscarFacturas(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<OperacionProducto> listaProductos= new ArrayList<OperacionProducto>();
  
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_FACTURA_BOLETA_BUSAR);
            rs=stmt.executeQuery();
            while(rs.next()){
                OperacionProducto productoC= OperacionProducto.operacionFROMDB(rs);
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
        public ArrayList<Producto> buscarFacturasProducto(String idOperacion){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Producto> listaProductos= new ArrayList<Producto>();
            System.out.println("ID operacion"+idOperacion);
        
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_FACTURA_BOLETAOPERACION);
            stmt.setString(1, idOperacion);
            rs=stmt.executeQuery();
            while(rs.next()){
                String codigoBarras=rs.getString("codigoBarras");
                String nombre=rs.getString("nombre");
                double cantidad=rs.getDouble("cantidad");
                double precioCompra=rs.getDouble("precioCompra");
                Producto productoC=new Producto();
                productoC.setCodigoBarras(codigoBarras);
                productoC.setNombre(nombre);
                productoC.setCantidad(cantidad);
                productoC.setPrecioEntrada(precioCompra);
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
    public int insertaOperacionProducto(OperacionProducto operacion){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
           
            stmt=conn.prepareStatement(SQL_FACTURA_BOLETA);
            stmt.setString(1, operacion.getIdOperacionProducto());
            stmt.setInt(2, operacion.getIdUsuario());
            stmt.setString(3, operacion.getNumeroSerie());
            stmt.setDouble(4, operacion.getPrecioTotal());
            stmt.setString(5, operacion.getTipo());
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
    
    public int insertaOperacionProductoOperacion(Producto producto,String idOperacion){
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
           
            stmt=conn.prepareStatement(SQL_FACTURA_BOLETA_PRODUCTO);
            stmt.setString(1, idOperacion);
            stmt.setInt(2, producto.getIdProducto());
            stmt.setDouble(3, producto.getCantidad());
            stmt.setDouble(4, producto.getPrecioEntrada());
            stmt.setDouble(5, producto.getPrecioSalida());

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
