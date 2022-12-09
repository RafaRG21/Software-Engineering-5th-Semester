/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Rafael Ruiz
 */
public class Cliente {
    public static final int PUERTO = 8080;
    public static final String HOST = "localhost";
    
    public static void main(String[] args) throws IOException{
        System.out.println("address: "+HOST);
        Socket socket = new Socket(HOST,PUERTO);
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            salida.println("Usuario: Hola server soy tu cliente que vale mil!");
            String str = entrada.readLine();
            System.out.println(str);
            salida.println("FIN");
        }finally{
            System.out.println("Cerrando...Adios!");
            socket.close();
        }
    }

}
