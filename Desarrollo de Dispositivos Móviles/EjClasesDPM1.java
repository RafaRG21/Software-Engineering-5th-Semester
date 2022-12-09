
import java.util.Scanner;
public class EjClasesDPM1{

    
    public static void main(String[] args){
    // Declaracion de variables 
    int numero1 =0, numero2=0, opcion=0;
    float real = 1.2f;
    char letra = 'z';
    
    String cadena = "ninguno";
    //Declaracion de una constante 
    final float iva = 0.16f;
    Scanner teclado = new Scanner(System.in);
    //main
    do {
        System.out.println("MENU PRINCIPAL");
        System.out.println("");
        System.out.println("1.- Capturar dos numeros");
        System.out.println("2.- Capturar una cantidad con decimales");
        System.out.println("3.- Capturar una letra");
        System.out.println("4.- Capturar una cadena ");
        System.out.println("5.- Mostrar contenido de variables");
        System.out.println("0.- Termina programa");
        System.out.println("Elige una opción");
        // Entrada de datos
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
            break;
            case 2:
            break;
            case 3:
            break;
            case 0:
            System.out.println("Conclusion del programa");
        } teclado.nextLine();
    
    }while(opcion!=0);
}
}//class