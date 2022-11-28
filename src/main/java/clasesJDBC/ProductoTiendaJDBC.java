/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Producto;
import clases.ProductoTienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import static repositorio.Conexion.close;
import static repositorio.Conexion.getConnection;

/**
 *
 * @author fell
 */
public class ProductoTiendaJDBC {
    
    private static final String SQL_BUSCADOR_PRODUCTO_TIENDA="SELECT" +
            "[inventarioMinimo]" +
            "FROM [dbo].[ProductoTienda] WHERE idProducto=?";
    
    // BUSCA A UN USUARIO
    public ProductoTienda buscarProducto(Producto producto){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ProductoTienda productoTienda= null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCADOR_PRODUCTO_TIENDA);
            System.out.println("ID producto: "+producto.getIdProducto());
            stmt.setDouble(1, producto.getIdProducto());
            rs=stmt.executeQuery();
            if(rs.next()){
                double cantidadMinima=rs.getInt("inventarioMinimo");
                productoTienda = new ProductoTienda(cantidadMinima);                    
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

        return productoTienda;
    }
    
    
}
