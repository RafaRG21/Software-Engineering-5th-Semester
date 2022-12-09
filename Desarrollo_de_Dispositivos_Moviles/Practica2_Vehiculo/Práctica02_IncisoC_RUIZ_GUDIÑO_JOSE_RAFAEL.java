import java.util.Scanner;

public class Práctica02_IncisoC_RUIZ_GUDIÑO_JOSE_RAFAEL {
    private static Scanner leer = new Scanner(System.in);
    public static void menu(){
        System.out.println("| Servicio de Vehiculos |");
        System.out.println("  1.-Registrar: ");
        System.out.println("  2.-Editar: ");
        System.out.println("  3.-Imprimir: ");
        System.out.println("  4.-Salir");
        System.out.print("  Opción a elegir: ");
    }
    public static void main(String[] args) {
        Trailer trailer = new Trailer();
        
        int opc=0;
        do{ 
            menu();
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    trailer.registrar();
                break;
                case 2:
                    if(trailer.getMarca()!=null){
                        trailer.editar();
                    }
                    else System.out.println("No hay vehiculo");
                break;
                case 3:
                    if(trailer.getMarca()!=null)
                        trailer.imprimir();
                    else 
                        System.out.println("No hay vehiculo");
                break;
                case 4:
                    System.out.println("Adios!");
            }
        }while(opc!=4);
    }
    
}