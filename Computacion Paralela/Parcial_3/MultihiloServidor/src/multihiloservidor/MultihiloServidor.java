/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multihiloservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;

/**
 *
 * @author Rafael Ruiz
 */
public class MultihiloServidor {
    public static final int PUERTO = 8080;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        ServerSocket server;
        System.out.println("Iniciando Servidor...");
        try{
            server = new ServerSocket(PUERTO);
            System.out.println("\t[OK]");
            int idSesion = 0;
            while(true){
                Socket socket;
                socket = server.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((ServidorMultiParlante)new ServidorMultiParlante(socket, idSesion)).start();
                
                idSesion++;
            }
        }catch(IOException ex){
            Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    

