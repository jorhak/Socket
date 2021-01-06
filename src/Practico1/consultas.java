/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practico1;

import java.sql.*;
import java.util.*;

/**
 *
 * @author jon
 */
public class consultas {

    private conexion con = new conexion();
    
    public String patron(String patron) throws SQLException {
        patron="%"+patron+"%"; 
        String cadena = "";
        try {
            String sql = "SELECT * FROM persona WHERE per_nom like '" + patron + "'";
            Connection conn = con.getConnect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            cadena = ordenado(rs);
            con.disConnect();
            return cadena;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cadena;
    }
    
    public String atributoPatron(String atri, String patron) throws SQLException{
        patron="%"+patron+"%"; 
        atri = atributo(atri);
        String cadena = "";
        try {
            String sql = "SELECT * FROM persona WHERE "+ atri + " like '" + patron + "'";
            Connection conn = con.getConnect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            cadena = ordenado(rs);
            con.disConnect();
            return cadena;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return cadena;
    }

    private String ordenado(ResultSet rs) {
        String ordenado = "";
        try {
            while (rs.next()) {
                for (int i = 1; i < 9; i++) {
                    String str = rs.getString(i);
                    String[] cadena = str.split("([^A-Za-z0-9]+)*\\s[^A-Za-z0-9]+(\\s[^A-Za-z0-9])+(\\s[^A-Za-z0-9])*");
                    for (int j = 0; j < cadena.length; j++) {
                        ordenado = ordenado + descripcion(i) + cadena[j] + " ";
                    }
                    ordenado+= "\n";
                }
                ordenado+="----------------------------------------------\n";
            }

            return ordenado;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ordenado;
    }

    private int cant_Atributos() {
        try {
            String sql = "SELECT COUNT(column_name) FROM information_schema.columns WHERE table_name='persona'";
            Connection conn = con.getConnect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            con.disConnect();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    private String descripcion(int valor){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Codigo: ");
        map.put(2, "Nombre: ");
        map.put(3, "Apellidos: ");
        map.put(4, "Profesion: ");
        map.put(5, "Telefono: ");
        map.put(6, "Celular: ");
        map.put(7, "E-mail: ");
        map.put(8, "Direccion: ");
        return map.get(valor);
    }
    
    private String atributo(String valor){
        Map<String, String> map = new HashMap<String, String>();
        map.put("Codigo", "per_cod");
        map.put("Nombre", "per_nom");
        map.put("Apellidos", "per_appm");
        map.put("Profesion", "per_prof");
        map.put("Telefono", "per_telf");
        map.put("Celular", "per_cel");
        map.put("Email", "per_email");
        map.put("Direccion", "per_dir");
        return map.get(valor);
    }

}
