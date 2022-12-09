import java.util.Scanner;

public class Práctica02_IncisoB_RUIZ_GUDIÑO_JOSE_RAFAEL {
    private static Scanner leer = new Scanner(System.in);
    public static void menu(){
        System.out.println("| Servicio de Herramienta |");
        System.out.println("  1.-Registrar: ");
        System.out.println("  2.-Editar: ");
        System.out.println("  3.-Imprimir: ");
        System.out.println("  4.-Salir");
        System.out.print("  Opción a elegir: ");
    }
    public static void main(String[] args) {
        HerramientaMecanica tool = new HerramientaMecanica();
        
        int opc=0;
        do{ 
            menu();
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    tool.registrar();
                break;
                case 2:
                    if(tool.getMarca()!=null){
                        tool.editar();
                    }
                    else System.out.println("No hay herramienta");
                break;
                case 3:
                    if(tool.getMarca()!=null)
                        tool.imprimir();
                    else 
                        System.out.println("No hay herramienta");
                break;
                case 4:
                    System.out.println("Adios!");
            }
        }while(opc!=4);
    }
    
}
