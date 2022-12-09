/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multimatrix;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Rafael Ruiz Gudiño 20110374
 */
public class MatrizForkJoin extends RecursiveAction {
private int[][] m1, m2, res;
    private int filas;

    MatrizForkJoin(int[][] m1, int[][] m2, int[][] res) {
        this(m1, m2, res, -1);
    }

    MatrizForkJoin(int[][] m1, int[][] m2, int[][] res, int filas) {
        this.m1 = m1;
        this.m2 = m2;
        this.res = res;
        this.filas = filas;
    } 

    @Override
    public void compute() {
        if (filas == -1) {
            List<MatrizForkJoin> tareas = new ArrayList<>();
            for (int filas = 0; filas < m1.length; filas++) { 
                tareas.add(new MatrizForkJoin(m1, m2, res, filas));
            }
            invokeAll(tareas);
        } else {
            multiplyRowByColumn(m1, m2, res, filas);
        }
        
    }

    void multiplyRowByColumn(int[][] m1, int[][] m2, int[][] res, int filas) {
        for (int j = 0; j < m2[0].length; j++) {
            for (int k = 0; k < m1[0].length; k++) {
                res[filas][j] += m1[filas][k] * m2[k][j];
            }
        }
    }
    
}
