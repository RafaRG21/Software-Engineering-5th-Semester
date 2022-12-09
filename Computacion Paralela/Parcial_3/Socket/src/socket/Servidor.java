/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rafael Ruiz
 */
public class Servidor {
    //Puerto 1-1024
public static final int PUERTO = 8080;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(PUERTO);
        System.out.println("Empezado: "+server);
        try{
            Socket socket = server.accept();
            try{
                System.out.println("Conexión acceptada: "+socket);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                while(true){
                    String str = entrada.readLine();
                    if(str.equals("FIN"))
                        break;
                    System.out.println("Reproduciendo: "+str);
                    salida.println(str);
      
                }//while
            }finally{
                System.out.println("Cerrando...");
                socket.close();
            }
        }finally{
            System.out.println("Server cerrado.");
            server.close();
        }
    }//main
    
}//class
