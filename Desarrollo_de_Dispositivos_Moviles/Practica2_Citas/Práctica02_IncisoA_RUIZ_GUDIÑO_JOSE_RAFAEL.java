import java.util.Scanner;

public class Práctica02_IncisoA_RUIZ_GUDIÑO_JOSE_RAFAEL{
    static Scanner leer = new Scanner(System.in);

    public static void menu(){
        System.out.println("| Servicio de Citas |");
        System.out.println("  1.-Registrar: ");
        System.out.println("  2.-Editar: ");
        System.out.println("  3.-Imprimir: ");
        System.out.println("  4.-Salir");
        System.out.println("  Opción a elegir: ");
    }

    public static void main(String[] args){
        Cita cita = new Cita();
        int opc=0;
        do{ 
            menu();
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    cita.registrar();
                break;
                case 2:
                    if(cita.getFecha()!=null){
                        cita.editar();
                    }
                    else System.out.println("No hay cita");
                break;
                case 3:
                    if(cita.getFecha()!=null)
                        cita.imprimir();
                    else 
                        System.out.println("No hay cita");
                break;
                case 4:
                    System.out.println("Adios!");
            }
        }while(opc!=4);
    }
    
}
