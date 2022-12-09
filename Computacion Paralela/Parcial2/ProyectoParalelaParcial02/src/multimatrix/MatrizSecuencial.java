/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multimatrix;

/**
 *
 * @author Rafael Ruiz Gudiño 20110374
 */
public class MatrizSecuencial {
    //Atributos

    private int[][] matriz01;
    private int[][] matriz02;
    private int[][] matrizresul;
  
    //Metodos

    MatrizSecuencial(int[][]m1,int[][]m2){
        this.matriz01 = m1;
        this.matriz02 = m2;
        this.matrizresul = new int[m1.length][m2[0].length];
        multiplicacionMatriz(this.matriz01,this.matriz02,this.matrizresul);
    }//Constructor
    
    private void multiplicacionMatriz(int [][] A,int [][] B,int[][] C){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
    }//multiplicacionMatriz
  
    

    public int[][] getMatrizresul(){
         return matrizresul;
    }//getMatrizresul
    
    
    
}
