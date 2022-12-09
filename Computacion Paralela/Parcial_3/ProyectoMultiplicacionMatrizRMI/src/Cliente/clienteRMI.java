/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Interfaces.chatServidor;
import Servidor.frmMatriz;
import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Rafael Ruiz
 */
public class clienteRMI {
    public static void main(String[] args) {

        try{
  
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            Registry rmii  = LocateRegistry.getRegistry("localhost",1005);
            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            frmMatriz ventana = new frmMatriz(nom);
            ventana.setServidor(servidor);
            ventana.setVisible(true);
            new Thread(new implementacionClienteChat(nom,servidor,ventana)).start();

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//Main
}//class
