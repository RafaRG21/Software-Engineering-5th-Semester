/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import cliente.implementacionClienteChat;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Rafael Ruiz
 */
public interface chatServidor extends Remote{
    public void registro(chatCliente cliente) throws RemoteException;
    public void mensaje(String mensaje) throws RemoteException;

}
