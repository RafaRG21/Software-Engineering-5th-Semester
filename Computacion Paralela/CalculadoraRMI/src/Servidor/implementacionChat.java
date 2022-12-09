package Servidor;

import Interfaces.chatCliente;
import Interfaces.chatServidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class implementacionChat extends UnicastRemoteObject implements chatServidor {
    public ArrayList<chatCliente> clientes;
    public String numero = "";
    public int cont = 0, num1 = 0, num2 = 0;

    implementacionChat() throws RemoteException {
        clientes =  new ArrayList<chatCliente>();
    }//Constructor
    public void mensaje(String mensaje, String nombre, String operacion) throws RemoteException{
        int clientNum  = 0;
        Scanner scan = new Scanner(System.in);
        cont++;
        System.out.println(nombre + ": "+mensaje);
        if(cont == 1){
            num1 = Integer.parseInt(mensaje);
        } else if(cont == 2){
            num2 = Integer.parseInt(mensaje);

            switch (operacion){
                case "+":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("La suma de " + num1 + " y " + num2 + " = " + (num1 + num2)));
                    }
                    clientNum++;
                    break;
                case "-":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("La resta de " + num1 + " y " + num2 + " = " + (num1 - num2)));
                    }
                    clientNum++;
                    break;
                case "*":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("La multiplicación de " + num1 + " y " + num2 + " = " + (num1 * num2)));
                    }
                    clientNum++;
                    break;
                case "/":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("La division de " + num1 + " y " + num2 + " = " + (num1 / num2)));
                    }
                    clientNum++;
                    break;
                case "^":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("La potencia de " + num1 + " a la " + num2 + " = " + (Math.pow(num1,num2))));
                    }
                    clientNum++;
                    break;
                case "%":
                    clientNum = 0;
                    while (clientNum<clientes.size()){
                        clientes.get(clientNum).mensajeCliente(String.valueOf("El modulo de " + num1 + " y " + num2 + " = " + (num1 % num2)));
                    }
                    clientNum++;
                    break;
            }//switch
            cont = 0;
        }//else


    }//mensaje
    public void registro(chatCliente cliente) throws RemoteException{
        this.clientes.add(cliente);
    }//registro

}//Class
