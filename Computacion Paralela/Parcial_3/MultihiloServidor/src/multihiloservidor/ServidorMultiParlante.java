/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihiloservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;

/**
 *
 * @author Rafael Ruiz
 */
public class ServidorMultiParlante extends Thread{
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSession;

    public ServidorMultiParlante(Socket socket, int idSession) {
        this.socket = socket;
        this.idSession = idSession;
        try{
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());

        }catch(IOException ex){
            Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE,null,ex);
        }
    
    }//ServidorMultiparlante

    public void desconnectar(){
        try{
            socket.close();
        }catch(IOException ex){
            Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE,null,ex);

        }
    }//desconectar
    @Override
    public void run(){
        String accion = "";
        try{
            accion = dis.readUTF();
            if(accion.equals("Hola")){
                System.out.println("El cliente con idSesion: "+idSession+" saluda :)");
                dos.writeUTF("Adios");
            }
        }catch(IOException ex){
            Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }

}//class
