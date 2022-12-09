/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Rafael Ruiz
 */
public class servidorRMI {
     public static void main(String[] args) {
        try{
            Registry rmi = LocateRegistry.createRegistry(1005);
            rmi.rebind("Chat",(Remote) new implementacionChat());
            System.out.println("Servidor Activo");
        }catch (Exception e){
            e.printStackTrace();
        }
    }//main
}//class
