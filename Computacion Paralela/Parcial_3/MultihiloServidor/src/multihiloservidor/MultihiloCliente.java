/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihiloservidor;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Ruiz
 */
public class MultihiloCliente {
    final static int MAX_HILOS = 10;
    public static final String HOST = "localhost";
    public static void main(String[] args) throws IOException, InterruptedException{
        ArrayList<Thread> clients = new ArrayList<Thread>();
        for(int i=0;i<5;i++){
            clients.add(new HiloClienteParlante(i));
        }
        for(Thread thread : clients){
            thread.start();
        }
    }//main

}//class
