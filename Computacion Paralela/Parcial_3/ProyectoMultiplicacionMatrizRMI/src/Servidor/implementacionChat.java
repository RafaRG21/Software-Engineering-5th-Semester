/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Interfaces.chatCliente;
import Interfaces.chatServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Rafael Ruiz
 */
public class implementacionChat extends UnicastRemoteObject implements chatServidor {
    public ArrayList<chatCliente> clientes;
    public int numero = 0;
    public int cont = 0, num1 = 0, num2 = 0;
    int filasM1 = 0, filasM2 = 0, columnasM1 = 0, columnasM2 = 0;
    boolean fM2 =false;

    frmMatriz ventana = new frmMatriz("SERVER");


    implementacionChat() throws RemoteException {
        clientes =  new ArrayList<chatCliente>();
    }//Constructor
    
    public void mensaje(String opc, String nombre,String res) throws RemoteException{
        int clientNum  = 0;
        System.out.println(nombre + " : " + opc);
        
        if(opc.equals("matriz1")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
        }else if(opc.equals("matriz2")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("sec")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("exec")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("fork")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("secImprimir")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("execimprimir")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("forkimprimir")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("matriz1imprimir")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("matriz2imprimir")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
            
        }else if(opc.equals("limpiar")){
             clientNum = 0;
            while (clientNum < clientes.size()) {
                clientes.get(clientNum++).mensajeCliente(String.valueOf(opc+"-"+res));
            }
        }
        //System.out.println(nombre + ": "+num);
      /*  switch(mensaje){
            case "fork":
                /*ventana.setVisible(true);
                while(clientNum<clientes.size())
                    clientes.get(clientNum++).mensajeCliente("Filas matriz 1:");
                clientNum = 0;
               // filasM1 = num;
                //ventana.fM1(filasM1);
                ventana.cliente(clientes);
                
                break;
            case "exec":
                /*
                while(clientNum<clientes.size())
                    clientes.get(clientNum++).mensajeCliente("Columnas matriz 1:");
                clientNum = 0;
                //columnasM1 = num;
                ventana.cM1(columnasM1);
                ventana.cliente(clientes);
                break;
            case "sec":
                while(clientNum<clientes.size())
                    clientes.get(clientNum++).mensajeCliente("Filas matriz 2:");
                //filasM2 = num;
                if(columnasM1!=filasM2){
                    cont--;
                    fM2 = true;
                    ventana.cliente(clientes);
                }else{
                    fM2 = false;
                    ventana.fM2(filasM2);
                    ventana.cliente(clientes);
                }
                clientNum = 0;
                break;
            case 4:
                while(clientNum<clientes.size())
                    clientes.get(clientNum++).mensajeCliente("Columnas matriz 2:");
                //columnasM2 = num;
                cont = 0;
                clientNum = 0;
                ventana.cM2(columnasM2);
                System.out.println(ANSI_GREEN+"Se ingreso una matriz de "+filasM1+"x"+columnasM1+" y otra de "+filasM2+"x"+columnasM2+ANSI_RESET);
                System.out.println(ANSI_GREEN+"Matriz resultante de "+filasM1+"x"+columnasM2+ANSI_RESET);
                ventana.cliente(clientes);
                
                break;     
        }
        
        while(clientNum<clientes.size())
          //  clientes.get(clientNum++).mensajeCliente(nombre+" ingreso: "+num);
        clientNum = 0;        
        if(columnasM1!=filasM2&&fM2)
            while(clientNum<clientes.size()){
                clientes.get(clientNum).mensajeAviso("Numero no válido, las filas de M2 deben ser iguales a las columnas de M1");
                clientes.get(clientNum).mensajeAviso("Ingrese de nuevo");
                clientNum++;
            }
        clientNum = 0; */       


    }//mensaje
    public void registro(chatCliente cliente) throws RemoteException{
        this.clientes.add(cliente);
    }//registro
}//class
