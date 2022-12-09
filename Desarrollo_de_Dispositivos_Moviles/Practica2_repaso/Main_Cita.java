import java.util.ArrayList;
import java.util.Scanner;

class Main_Cita{
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
        ArrayList<Cita> citas  = new ArrayList<Cita>();
        Cita cita = new Cita();
        int opc=0, edit=0;
        do{ 
            menu();
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    cita.registrar(citas);
                break;
                case 2:
                    if(citas.size()>0){
                        cita.imprimir(citas);
                        System.out.println("Registro a editar: ");
                        edit  = leer.nextInt();
                        edit--;
                        cita.editar(citas,edit);
                    }
                    else System.out.println("No hay citas");
                break;
                case 3:
                    if(citas.size()>0){
                        cita.imprimir(citas);
                    } 
                    else System.out.println("No hay citas");
                break;
                case 4:
                    System.out.println("Adios!");
            }
        }while(opc!=4);
    }
}