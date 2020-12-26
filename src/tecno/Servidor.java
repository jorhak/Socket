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
public class Servidor {
    static final int PUERTO = 5000;
    
    public Servidor(){
        try{
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("S: Escucha el puerto "+ PUERTO);
            for(int numCli=0; numCli<=3;numCli++){
                Socket skCliente = skServidor.accept(); //Crea objeto
                System.out.println("S: Sirvo al cliente "+ numCli);
                DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());
                salida.writeBytes("Hola cliente "+ numCli);
                skCliente.close();
            }
            System.out.println("S: Demasiados clientes por hoy");
         }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args){
        Servidor s = new Servidor(); 
    }
}
