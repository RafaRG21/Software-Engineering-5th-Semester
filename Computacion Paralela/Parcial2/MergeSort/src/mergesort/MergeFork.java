/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergesort;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Usuario
 */
public class MergeFork extends RecursiveAction {
      public int[] arreglo;
    
    public MergeFork(int[] arreglo){
        this.arreglo = arreglo;
    }
    
    @Override
    protected void compute() {

        if (arreglo.length < 2) return;
        int mid = arreglo.length / 2;

        int[] izq = new int[mid];
        System.arraycopy(arreglo, 0, izq, 0, mid);

        int[] der = new int[arreglo.length - mid];
        System.arraycopy(arreglo, mid, der, 0, arreglo.length - mid);

        invokeAll(new MergeFork(izq), new MergeFork(der));
        merge(izq, der);
    }//compute
    
    
    private void merge(int[] izq, int[] der) {
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (izq[i] < der[j])
                arreglo[k++] = izq[i++];
            else
                arreglo[k++] = der[j++];
        }
        while (i < izq.length) {
            arreglo[k++] = izq[i++];
        }
        while (j < der.length) {
            arreglo[k++] = der[j++];
        }
    
    }//merge
}//class
