package Cliente;

import Interfaces.chatCliente;
import Interfaces.chatServidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente,Runnable{
    chatServidor servidor;
    public String nombre = null;
    implementacionClienteChat(String nombre, chatServidor servidor) throws RemoteException {
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }//constructor

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        String mensaje,operacion;
        while (true) {
            System.out.println("Escribe un numero");
            mensaje = scan.nextLine();
            try{
                System.out.println(nombre+" escribio: "+mensaje);
                System.out.println("Elige la operacion: +, -, *, /, ^");
                operacion = scan.nextLine();
                servidor.mensaje(mensaje,nombre,operacion);

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.out.println("Resultado: "+mensaje);
    }
}//class
