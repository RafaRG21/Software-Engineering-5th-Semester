/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Interfaces.chatCliente;
import Interfaces.chatServidor;
import Servidor.frmMatriz;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
/**
 *
 * @author Rafael Ruiz
 */
public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente,Runnable{
    chatServidor servidor;
    public String nombre = null;
    frmMatriz ventana;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    implementacionClienteChat(String nombre, chatServidor servidor, frmMatriz ventana) throws RemoteException {
        this.nombre = nombre;
        this.servidor = servidor;
        this.ventana = ventana;
        servidor.registro(this);
    }//constructor

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        /*int num=0;
        while (true) {
            System.out.println("Ingresa un número: ");
            num = scan.nextInt();
            try{
                servidor.mensaje(num,nombre);

            }catch (Exception e){
                e.printStackTrace();
            }

        }*/
    }

    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        String[] res=mensaje.split("-");
        if(res[0].equals("fork")){
            ventana.forkTime("");
            ventana.forkTime(res[1]);

        }else if(res[0].equals("exec")){
            ventana.execTime("");
            ventana.execTime(res[1]);
        }else if(res[0].equals("sec")){
            ventana.secTime("");
            ventana.secTime(res[1]);
        }else if(res[0].equals("matriz1")){
           
            ventana.matriz1("");
            ventana.matriz1(res[1]);
            ventana.matriz1 = ventana.llenarMatriz(ventana.matriz1, Integer.valueOf(res[2]),Integer.valueOf(res[3]));
            ventana.fM1(Integer.valueOf(res[2]));
            ventana.cM1(Integer.valueOf(res[3]));
           
        }else if(res[0].equals("matriz2")){
            ventana.matriz2 = ventana.llenarMatriz(ventana.matriz2, Integer.valueOf(res[2]),Integer.valueOf(res[3]));
            ventana.matriz2("");
          //  ventana.matriz2(res[1]);
            ventana.fM2(Integer.valueOf(res[2]));
            ventana.cM2(Integer.valueOf(res[3]));
        }else if(res[0].equals("secImprimir")){
            
            ventana.secuencial("");
            ventana.secuencial(res[1]);
        }else if(res[0].equals("execimprimir")){
            ventana.executorService("");            
            ventana.executorService(res[1]);
            
        }else if(res[0].equals("forkimprimir")){
            ventana.forkjoin("");            
            ventana.forkjoin(res[1]);
            
        }else if(res[0].equals("matriz1imprimir")){
            ventana.matriz1("");
            ventana.matriz1(res[1]);
            
        }else if(res[0].equals("matriz2imprimir")){
           ventana.matriz2("");
            ventana.matriz2(res[1]);
            
        }else if(res[0].equals("limpiar")){
            ventana.matriz1("");
            ventana.matriz2("");
            ventana.forkjoin("");            
            ventana.forkTime("");            
            ventana.execTime("");
            ventana.executorService("");
            ventana.secTime("");
            ventana.secuencial("");
            ventana.cM1(0);
            ventana.cM2(0);
            ventana.fM1(0);
            ventana.fM2(0);
            
            
            
        }
    }

    @Override
    public void resultado(String matrizRes) throws RemoteException {
        System.out.println(ANSI_PURPLE+matrizRes+ANSI_RESET);
    }

    @Override
    public void mensajeAviso(String mensaje) throws RemoteException {
        System.out.println(ANSI_RED+mensaje+ANSI_RESET);
    }
}//class
