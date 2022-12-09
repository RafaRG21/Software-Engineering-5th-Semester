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
public interface chatServidor extends Remote{
    void registro(chatCliente cliente) throws RemoteException;
    void mensaje(String opc, String nombre, String res) throws RemoteException;
    
}//interface
