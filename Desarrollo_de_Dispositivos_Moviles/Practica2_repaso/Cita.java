import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;

class Cita{
    //Atributos
    private String fecha;
    private String hora;
    private String lugar;
    private Scanner leer = new Scanner(System.in);
    //Constructor generico
    Cita(){

    }
    //Constructor personalizado
    Cita(String fecha,String hora,String lugar){
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    public void registrar(ArrayList<Cita> c){
        String fecha, hora, lugar;
        
        System.out.println("Ingresar fecha: ");
        fecha = leer.nextLine();
        System.out.println("Ingresar hora: ");
        hora = leer.nextLine();
        System.out.println("Ingresar lugar: ");
        lugar = leer.nextLine();
        c.add(new Cita(fecha,hora,lugar));
        System.out.println("Registro realizado!");
    }
    public void editar(ArrayList<Cita> c,int edit){
            int opc=0;
            System.out.println("Campo a editar: ");
            System.out.println("1.- Fecha: "+c.get(edit).getFecha());
            System.out.println("2.- Hora: "+c.get(edit).getHora());
            System.out.println("3.- Lugar: "+c.get(edit).getLugar());
            opc = leer.nextInt();
            leer.nextLine();
            switch(opc){
                case 1: 
                    System.out.println("Ingrese nueva fecha: ");
                    c.get(edit).setFecha(leer.nextLine());
                    System.out.println("Nueva fecha: "+c.get(edit).getFecha());
                    break;
                case 2:
                    System.out.println("Ingrese nueva hota: ");
                    c.get(edit).setHora(leer.nextLine());
                    System.out.println("Nueva hora: "+c.get(edit).getHora());
                    break;
                case 3:
                    System.out.println("Ingrese nuevo lugar: ");
                    c.get(edit).setLugar(leer.nextLine());
                    System.out.println("Nueva lugar: "+c.get(edit).getLugar());
                break;
                default: System.out.println("Campo no valido");
            }
    }
    public void imprimir(ArrayList<Cita> c){
        System.out.println();
        System.out.println("Informacion de las citas: ");
        System.out.println();
        for(int i=0;i<c.size();i++){
            System.out.println("Cita "+(i+1));
            System.out.println("Fecha: "+c.get(i).getFecha());
            System.out.println("Hora: "+c.get(i).getHora());
            System.out.println("Lugar: "+c.get(i).getLugar());
        }
    }
    //getters y setters
    public String getFecha(){
        return this.fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getHora(){
        return this.hora;
    }
    public void setHora(String hora){
        this.hora = hora;
    }
    public String getLugar(){
        return this.lugar;
    }
    public void setLugar(String lugar){
        this.lugar = lugar;
    }
   

}