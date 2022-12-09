/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Rafael Ruiz
 */
public interface chatCliente extends Remote{
    void mensajeCliente(String mensaje) throws RemoteException;
    void mensajeAviso(String mensaje) throws RemoteException;
    void resultado(String matrizRes) throws RemoteException;


}//interface
