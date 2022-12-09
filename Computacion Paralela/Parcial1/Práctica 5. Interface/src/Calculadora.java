import java.util.Scanner;

import static java.lang.Math.pow;

public class Calculadora implements iOperaciones, iMenu{
    Scanner leer = new Scanner(System.in);

    public static void main(String[] args){
        Calculadora calculadora = new Calculadora();
    }

    Calculadora(){
        casos();
    }

    @Override
    public void casos() {
        int opc=0;

        do{
            int numI1=0,numI2=0,resI=0;
            float num1=0,num2=0,res=0;
            double numD1=0,numD2=0,resD=0;
            opc = generarMenu(opc);

            switch(opc){
                case 1:
                    System.out.println("Ingresa un número: ");
                    num1 = leer.nextFloat();
                    System.out.println("Ingresa otro número: ");
                    num2 = leer.nextFloat();
                    res = suma(num1,num2);
                    System.out.println("La suma "+num1+" + "+num2+" = "+res);

                    break;
                case 2:
                    System.out.println("Ingresa un número: ");
                    num1 = leer.nextFloat();
                    System.out.println("Ingresa otro número: ");
                    num2 = leer.nextFloat();
                    res = resta(num1,num2);
                    System.out.println("La resta "+num1+" - "+num2+" = "+res);
                    break;
                case 3:
                    System.out.println("Ingresa un número: ");
                    num1 = leer.nextFloat();
                    System.out.println("Ingresa otro número: ");
                    num2 = leer.nextFloat();
                    res = multiplicacion(num1,num2);
                    System.out.println("La multiplicación "+num1+" * "+num2+" = "+res);
                    break;
                case 4:
                    System.out.println("Ingresa un número: ");
                    num1 = leer.nextFloat();
                    System.out.println("Ingresa otro número: ");
                    num2 = leer.nextFloat();
                    res = division(num1,num2);
                    System.out.println("La división "+num1+" / "+num2+" = "+res);
                    break;
                case 5:
                    System.out.println("Ingresa un número: ");
                    numD1 = leer.nextDouble();
                    System.out.println("Ingresa otro número: ");
                    numD2 = leer.nextDouble();
                    resD = potencia(numD1,numD2);
                    System.out.println("La potencia "+numD1+"^"+numD2+" = "+resD);
                    break;
                case 6:
                    System.out.println("Ingresa un número: ");
                    numI1 = leer.nextInt();
                    System.out.println("Ingresa otro número: ");
                    numI2 = leer.nextInt();
                    resI = modulo(numI1,numI2);
                    System.out.println("El módulo "+numI1+"%"+numI2+" = "+resI);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }

        }while(opc!=7);
    }

    @Override
    public int generarMenu(int opc) {
        System.out.println("Calculadora");
        System.out.println("1.- Suma");
        System.out.println("2.- Resta");
        System.out.println("3.- Multiplicación");
        System.out.println("4.- División");
        System.out.println("5.- Potencia");
        System.out.println("6.- Módulo");
        System.out.println("7.- Salir");
        System.out.println("Elige una opción: ");
        opc = leer.nextInt();
        return opc;
    }


    @Override
    public float suma(float a, float b) {
        return a + b;
    }
    @Override
    public float resta(float a, float b) {
        return a - b;
    }

    @Override
    public float multiplicacion(float a, float b) {
        return a * b;
    }

    @Override
    public float division(float a, float b) {
        return a / b;
    }

    @Override
    public double potencia(double a, double b) {
        double res = pow(a,b);
        return res;
    }

    @Override
    public int modulo(int a, int b) {
        return a%b;
    }
}
