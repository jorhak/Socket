/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico1;

import java.sql.*;

/**
 *
 * @author jon
 */
public class conexion {

    public void conn() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connection = null;
            //Database connect
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/hola", "postgres", "toor");
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "Test OK" : "Test FAIL");
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT* FROM pais");
            System.out.println("ID  NOMBRE");
            while(rs.next()){
                System.out.println(rs.getInt("id")+"   "+rs.getString("nombre"));
                
            }
            
            stm.close();
            connection.close();
            
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }
    
    public void connectDatabase(String host, String port, String database,
            String user, String password) {
        String url = "";
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connection = null;
            url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    url,
                    user, password);           
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT per_nom FROM persona");
            System.out.println("ID");
            while(rs.next()){
                System.out.println(rs.getInt("per_nom"));
                
            }
            
            stm.close();
            connection.close();
            
            
        } catch (java.sql.SQLException sqle) { 
            System.out.println("Error al conectar con la base de datos de PostgreSQL (" + url + "): " + sqle);
        }
    }

    public static void main(String[] args) {
        conexion c = new conexion();
        //c.conn();
        c.connectDatabase("www.tecnoweb.org.bo", "5432", "db_agenda", "agenda", "agendaagenda");
    }

}
