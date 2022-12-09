/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;
import interfaces.chatCliente;
import interfaces.chatServidor;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Rafael Ruiz
 */
public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente, Runnable {
    chatServidor servidor;
    public String nombre=null;
    
    implementacionClienteChat(String nombre, chatServidor servidor) throws RemoteException{
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }//constructor

    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }//mensajeCliente

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        String mensaje;
        while(true){
            mensaje = scan.nextLine();
            try{
                servidor.mensaje(nombre+":"+mensaje);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//run
}//class
