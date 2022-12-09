/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergesort;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class MergeSort {
 
    public static void main(String[] args){
        int[] num = new int[100];
        num = llenado(num);
        System.out.println("\nArreglo ordenado");
        System.out.println(imprimirNum(num));
        System.out.println("\nArreglo desordenado");
        mergeSort(num);
        System.out.println(imprimirNum(num));

    }
    public static int[] llenado(int[] array){
         Random rand = new Random();
         for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(99);
        }
         return array;
    }
    //Algoritmo de divide y venceras
    public static void mergeSort(int[] arregloEntrada){
        int tam = arregloEntrada.length;
        //Si el arreglo es de tam 1 se retorna
        if(tam<2){
            return;
        }
        // sino se divide el arreglo en dos mitades
        int midIndex = tam/2;
        int[] izqMitad = new int[midIndex];
        int[] derMitad = new int[tam - midIndex];
        //Llenado por la izquierda
        for(int i=0; i<midIndex;i++){
            izqMitad[i] = arregloEntrada[i];
        }
        //Llenado por la derecha
        for(int i = midIndex;i<tam;i++){
            derMitad[i-midIndex] = arregloEntrada[i];
        }
        //Volvemos a ejecutar el algoritmo con las dos mitades
        mergeSort(izqMitad);
        mergeSort(derMitad);
        
        //Juntamos los arreglos separados para ordenarlos
        merge(arregloEntrada,izqMitad,derMitad);
        
    }//mergeSort
    
    private static void merge(int[] arregloFull, int[] izqMitad, int[] derMitad){
        int tamIzq = izqMitad.length;
        int tamDer = derMitad.length;
        int i=0, j=0, k=0;
        
        while(i<tamIzq && j<tamDer){
            if(izqMitad[i] <= derMitad[j]){
                arregloFull[k] = izqMitad[i];
                i++;
            }
            else{
                arregloFull[k] = derMitad[j];
                j++;
            }
            k++;
        }// while(i<tamIzq && j<tamDer)
        while(i<tamIzq){
            arregloFull[k] = izqMitad[i];
            i++;
            k++;
        }// while(i<izqMitad)
        while(j<tamDer){
            arregloFull[k] = derMitad[j];
            j++;
            k++;
        }//while(j<tamDer)
    }// merge method
    static String imprimirNum(int[] numeros){
        String text="";
        for(int i=0;i<numeros.length;i++){
            text += String.valueOf(numeros[i] + " ");
        }
        
        return text;
    }//imprimirNum
}//class MergeSort