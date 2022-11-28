/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesJDBC;

import clases.Categoria;
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
public class CategoriaJDBC {


    private static final String SQL_BUSCAR_CATEGORIAS="SELECT [idCategoria]" +
            ",[nombre]" +
            ",[descripcion]" +
            " ,[fechaCreacion]" +
            "FROM [dbo].[Categoria]";
    
    private static final String SQL_BUSCAR_NOMBRE="SELECT [idCategoria]" +
            ",[nombre]" +
            ",[descripcion]" +
            " ,[fechaCreacion]" +
            "FROM [dbo].[Categoria] WHERE nombre=?";
    private static final String SQL_BUSCAR_NOMBRE_PARECIDO="{call buscar_categoriaNombre(?)}";
    private static final String SQL_INSERTAR_CATEGORIA="INSERT INTO [dbo].[Categoria]" + 
            "([nombre]" +
            ",[descripcion]" +
            ",[fechaCreacion])" +
            "VALUES" +
            "(?" +
            ",?" +
            ",GETDATE())";
    
    
    private static final String SQL_MODIFICAR_CATEGORIA="UPDATE [dbo].[Categoria] SET [nombre] =?,[descripcion] = ? WHERE idCategoria= ?";
    
    private static final String SQL_ELIMINAR_CATEGORIA="DELETE FROM [dbo].[Categoria] WHERE idCategoria= ?";
    public ArrayList<Categoria> buscarCategoriasTodos(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Categoria> categorias=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_CATEGORIAS);

            rs=stmt.executeQuery();
            while(rs.next()){

                int idCategoria=rs.getInt("idCategoria");
                String nombre=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                Date fechaCreacion=rs.getDate("fechaCreacion");
 
                categorias.add(new Categoria(idCategoria,nombre,descripcion, 
                        fechaCreacion));

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
        
        

        return categorias;
    }  
    

    public Categoria buscarCategoriasNombre(String nombreBuscado){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Categoria categoria=null;
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_NOMBRE);
            stmt.setString(1,nombreBuscado);
            rs=stmt.executeQuery();
            if(rs.next()){

                int idCategoria=rs.getInt("idCategoria");
                String nombre=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                Date fechaCreacion=rs.getDate("fechaCreacion");
 
                categoria=new Categoria(idCategoria,nombre,descripcion, 
                        fechaCreacion);

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
        
        

        return categoria;
    }  
    
    
    public ArrayList<Categoria> buscarCategoriasListaNombre(String nombreBuscado){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Categoria categoria=null;
        ArrayList<Categoria> categorias=new ArrayList<>();
        try {
            conn= getConnection();
            stmt=conn.prepareStatement(SQL_BUSCAR_NOMBRE_PARECIDO);
            stmt.setString(1,nombreBuscado);
            rs=stmt.executeQuery();
            while(rs.next()){

                int idCategoria=rs.getInt("idCategoria");
                String nombre=rs.getString("nombre");
                
                String descripcion=rs.getString("descripcion");
                Date fechaCreacion=rs.getDate("fechaCreacion");
                categorias.add(new Categoria(idCategoria,nombre,descripcion, 
                        fechaCreacion));
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
        
        

        return categorias;
    }  
    
    
    public int insertarCategoria(Categoria categoria){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();

            stmt=conn.prepareStatement(SQL_INSERTAR_CATEGORIA);
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
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
    
    
    public int modificarCategoria(Categoria categoria){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            System.out.println(" id Categoria :"+categoria.getIdCategoria());
            System.out.println(" nombre :"+categoria.getNombre());
            System.out.println("descripcion :"+categoria.getDescripcion());
            stmt=conn.prepareStatement(SQL_MODIFICAR_CATEGORIA);
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setInt(3, categoria.getIdCategoria());
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
    
     public int eliminaCategoria(int idCategoria){
    
        Connection conn=  null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=  getConnection();
            stmt=conn.prepareStatement(SQL_ELIMINAR_CATEGORIA);
            stmt.setInt(1, idCategoria);
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
