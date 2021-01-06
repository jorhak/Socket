/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practico1;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jon
 */
public class prueba {

    public static void main(String[] args) throws SQLException {
//        conexion c = new conexion();
//        Connection conn = c.getConnect();
//        if (conn != null) {
//            System.out.println("Connection Successfull");
//        } else {
//            System.out.println("Connection Fail");
//        }
//        String cad ="";
//        String patron ="%E%";
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery("SELECT * FROM persona WHERE per_nom like '"+patron+"'");
//        while (rs.next()) {
//            for (int j = 1; j < 9; j++) {
//                String str = rs.getString(j);
//                String[] cadena = str.split("([^A-Za-z0-9]+)*\\s[^A-Za-z0-9]+(\\s[^A-Za-z0-9])+(\\s[^A-Za-z0-9])*");
//
//                String [] cadena = str.split("[   ]");
//                for (int i = 0; i < cadena.length; i++) {
//                    System.out.println(cadena[i].length());
//                    cad+= cadena[i]+" ";
//                    System.out.println(cadena[i]);
//                }
//                
//            }
//            cad+="\n";
//            System.out.println(rs.getString(1).length());
//            System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
//        }
//        System.out.println(cad);
    consultas c = new consultas();
    System.out.println(c.atributoPatron("Telefono","88"));
    
    }

}
