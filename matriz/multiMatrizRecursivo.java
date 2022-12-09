import java.util.Random;

public class multiMatrizRecursivo {
    static Random rand = new Random();
    public static void main(String[] args) {
        int filas1 = 5, columnas1=3;
        int filas2 = 3, columnas2=2;
        int[][] matriz1, matriz2;
        matriz1 = new int[filas1][columnas1];
        matriz2 = new int[filas2][columnas2];
        rellenarMatriz(matriz1,filas1,columnas1);
        rellenarMatriz(matriz2, filas2, columnas2);
        imprimirMatriz(matriz1, filas1, columnas1);
        imprimirMatriz(matriz2, filas2,columnas2);
        multiplicacionMatriz(matriz1,matriz2);
    

 
    }
        public static void rellenarMatriz(int[][] soup, int i, int j) {
            soup[i][j] = rand.nextInt(90);
            if (j < soup[i].length - 1) {
                rellenarMatriz(soup, i, j + 1);
            }
        }
   
    private static void imprimirMatriz(int[][] matriz,int filas,int columnas){
        System.out.println("Matriz:");
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void multiplicacionMatriz(int [][] A,int [][] B)
    {
        if (A[0].length==B.length)
  
        {
            int[][] C = new int[A.length][B[0].length];
            multiplicarMatrizFilaA(A, B, C, 0);
            imprimir(C);
        }else
        {
            System.out.println("las matrices que ingreso no soy compatibles");
        }
    }
  
    private static void multiplicarMatrizFilaA(int [][] A,int [][] B,int [][]C,int i)
    {
  
        if (i<A.length)
        {
            multiplicarMatrizColumnaB(A,B,C,i,0);
            multiplicarMatrizFilaA(A,B,C,i+1);
        }
    }
  
    private static void  multiplicarMatrizColumnaB(int [][]A,int [][]B,int [][]C,int i,int j)
    {
        if (j<B[0].length)
        {
            multiplicarMatrizColumnaB(A,B,C,i,j,0);
            multiplicarMatrizColumnaB(A,B,C,i,j+1);
        }
    }
  
    private static void multiplicarMatrizColumnaB(int [][]A,int [][]B,int [][]C,int i,int j,int k)
    {
        if (k<A[0].length)
        {
            C[i][j] += A[i][k] * B[k][j];
            multiplicarMatrizColumnaB(A,B,C,i,j,k+1);
        }
    }
  
    public static void imprimir(int [][] C)
    {
  
        for (int i=0;i<C.length;i++)
        {
            for(int j=0;j<C[0].length;j++)
            {
                System.out.print("["+C[i][j]+"]");
            }
            System.out.println();
        }
    }
  
 }