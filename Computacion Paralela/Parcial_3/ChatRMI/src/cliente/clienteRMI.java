/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import interfaces.chatServidor;
import javax.swing.JOptionPane;
       
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Rafael Ruiz
 */
public class clienteRMI {
    public static void main(String[] args){
        try{
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            Registry rmii = LocateRegistry.getRegistry("localhost",1005);
            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            new Thread(new implementacionClienteChat(nom,servidor)).start();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//main
}//class
