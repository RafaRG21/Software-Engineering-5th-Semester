/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihiloservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Ruiz
 */
public class HiloClienteParlante extends Thread{

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSession;
    public static final int PUERTO = 8080;
    public static final String HOST = "localhost";
    
    public HiloClienteParlante(int idSession) {
        this.idSession = idSession;
    }
    @Override
    public void run() {
        try{
            socket = new Socket(HOST,PUERTO);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            System.out.println(idSession +" envia saludos!");
            dos.writeUTF("Hola");
            String respuesta = " ";
            respuesta = dis.readUTF();
            System.out.println(idSession+" Servidor devuelve saludos: "+respuesta);
            dis.close();
            dos.close();
            socket.close();;

        }catch(IOException ex){
            Logger.getLogger(HiloClienteParlante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
