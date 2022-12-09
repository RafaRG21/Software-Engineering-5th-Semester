/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import interfaces.chatCliente;
import interfaces.chatServidor;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Rafael Ruiz
 */
public class implementacionChat extends UnicastRemoteObject implements chatServidor{
    public ArrayList<chatCliente> clientes;
    public String numero ="", opc="",opc2="2";
    public int cont = 0, num1=0,num2=0;
    public implementacionChat() throws RemoteException{
        clientes = new ArrayList<chatCliente>();
    }//implementacionChat
    
    public void mensaje(String mensaje) throws RemoteException{
        int a = 0;
        while(a<clientes.size()){
            clientes.get(a++).mensajeCliente(mensaje);
        }
    }//mensaje
    public void registro(chatCliente cliente) throws RemoteException{
        this.clientes.add(cliente);
    }//registro
}//class
