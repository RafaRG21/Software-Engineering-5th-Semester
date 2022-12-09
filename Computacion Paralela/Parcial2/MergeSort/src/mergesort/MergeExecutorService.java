/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergesort;

/**
 *
 * @author Usuario
 */
public class MergeExecutorService implements Runnable{

    int cantidad;
    int arreglo[] = new int[cantidad];
    String resultado = "";

    public MergeExecutorService(int[] arreglo, int cantidad) {
        this.arreglo = arreglo;
        this.cantidad = cantidad;
    }

    public void run() {
        
        mergeSort(arreglo, cantidad);
        for(int i =0; i< arreglo.length;++i){
            resultado = resultado + arreglo[i];
            if(i != arreglo.length-1)
                resultado = resultado + ", ";
        }
        System.out.println("");
         
    }
    
    public static void mergeSort(int[] arreglo, int longitud) {
        if (longitud < 2) {
            return;
        }
        int mitad = longitud / 2;
        int[] izquierda = new int[mitad];
        int[] derecha = new int[longitud - mitad];

        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = mitad; i < longitud; i++) {
            derecha[i - mitad] = arreglo[i];
        }
        mergeSort(izquierda, mitad);
        mergeSort(derecha, longitud - mitad);

        merge(arreglo, izquierda, derecha, mitad, longitud - mitad);
    }
    
    
    public static void merge(
        int[] arreglo, int[] left, int[] right, int izquierda, int derecha) {

        int i = 0, j = 0, k = 0;
        while (i < izquierda && j < derecha) {
            if (left[i] <= right[j]) {
                arreglo[k++] = left[i++];
            }
            else {
                arreglo[k++] = right[j++];
            }
        }
        while (i < izquierda) {
            arreglo[k++] = left[i++];
        }
        while (j < derecha) {
            arreglo[k++] = right[j++];
        }
    }
}
