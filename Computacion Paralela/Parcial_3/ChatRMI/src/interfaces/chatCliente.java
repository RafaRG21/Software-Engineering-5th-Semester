/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Rafael Ruiz
 */
public interface chatCliente extends Remote{
    public void mensajeCliente(String mensaje) throws RemoteException;
}
