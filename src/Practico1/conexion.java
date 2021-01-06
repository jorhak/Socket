
package Practico1;
import java.sql.*;
/**
 *
 * @author jon
 */
public class conexion {
    Connection conn = null;
    private final String url = "jdbc:postgresql://www.tecnoweb.org.bo/db_agenda";
    private final String user = "agenda";
    private final String password = "agendaagenda";
    
    public conexion(){
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnect(){
        return this.conn;
    }
    
    public void disConnect() throws SQLException{
        this.conn.close();
        System.out.println("The connection: Close");
        
    }
    
}
