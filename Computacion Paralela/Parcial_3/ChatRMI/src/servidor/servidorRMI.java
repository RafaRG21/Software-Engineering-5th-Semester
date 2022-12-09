/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;
import java.rmi.registry.Registry;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Rafael Ruiz
 */
public class servidorRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry rmi = LocateRegistry.createRegistry(1005);
            rmi.rebind("Chat",(Remote) new implementacionChat());
            System.out.println("Servidor activo");
        }catch(Exception e){
          e.printStackTrace();
    }   }
    
    
    
}
