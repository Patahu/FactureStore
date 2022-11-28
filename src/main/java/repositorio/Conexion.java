package repositorio;



import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Conexion {
    private static final String JDBC_URL="jdbc:sqlserver://localHost:1433;databaseName=dbAnden";
    private static int operacion=0;
    public static Connection getConnection(){
        Connection conn=null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(JDBC_URL,"USERANDEN","kun kun side 54 lol");
        
            System.out.println("Conexion ="+operacion);
            operacion++;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e){
            
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
