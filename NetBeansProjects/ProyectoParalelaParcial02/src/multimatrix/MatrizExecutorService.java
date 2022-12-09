/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multimatrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rafael Ruiz Gudiño 20110374
 */
public class MatrizExecutorService{

    
    private static int[][] res;
 public static  void multiplicarExecutorService(int[][] m1,int[][] m2, int numHilos) {

    int f1 = m1.length;
    int f2 = m2.length;
    int c2 = m2[0].length;
    res = new int[m1.length][m2[0].length];
    ExecutorService executor = Executors.newFixedThreadPool(numHilos);
    for (int i = numHilos, fin = c2, size = (int) Math.ceil(c2 * 1.0 / numHilos);i > 0;i--, fin -= size) {
        int to = fin;
        int from = Math.max(0, fin - size);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int[] M2Colj = new int[f2];
                for (int j = from; j < to; j++) {
                    for (int k = 0; k < f2; k++) {
                        M2Colj[k] = m2[k][j];
                    }
                    for (int i = 0; i < f1; i++) {
                        int[] M1Filai = m1[i];
                        int ans = 0;
                        for (int k = 0; k < f2; k++) {
                            ans += M1Filai[k] * M2Colj[k];
                        }
                        res[i][j] = ans;
                    }
                }
            }
        };
        
        executor.execute(runnable);
        
    }
    try {
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.DAYS); 
    } catch (InterruptedException e) {
        System.out.println("Interrupted.");
        
    }
}
 
 public static int[][] getRes() {
        return res;
    }
  
}//class
