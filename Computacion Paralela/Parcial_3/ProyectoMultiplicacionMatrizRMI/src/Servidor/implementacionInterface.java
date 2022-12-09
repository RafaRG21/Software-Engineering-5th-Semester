/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Interfaces.interfaceRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Rafael Ruiz
 */
public class implementacionInterface extends UnicastRemoteObject implements interfaceRMI{
    implementacionInterface() throws RemoteException {
        super();
    }//constructor
    public String nombre(String nombre) throws RemoteException{
        return nombre;
    }//nombre
}//class
