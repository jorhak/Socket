/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecno;
import java.net.*;
import java.io.*;
/**
 *
 * @author jon
 */
public class Cliente {
    static final String HOST = "localhost";
    static final int PUERTO = 5000;
    
    public Cliente(){
        try{
            Socket skCliente = new Socket(HOST,PUERTO);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            System.out.println("C: Conectado a <"+HOST+">");
            System.out.println("S:"+ entrada.readLine());
            skCliente.close();
            System.out.println("C: Desconectado del <"+HOST+">");
        }catch(Exception e){
            System.out.println("C:"+ e.getMessage());
        }
    }
    
    public static void main(String[] args){
        //TODO Auto-generated method stub
        Cliente c = new Cliente();
    }
}
