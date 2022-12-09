

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentMatrixPrint {
    private int[][] matrix;
    Random rand = new Random();
    public ConcurrentMatrixPrint(int n,int m){
        matrix = new int[n][m];
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++)
                matrix[i][j] = rand.nextInt(50);
        }
    }

    public void printRow(int row){
        //Creates a builder and initializes with the thread id and a tab
        StringBuilder sb = new StringBuilder();
        sb.append(Thread.currentThread().getId());
        sb.append("\t");

        //Loop through columns in the current row
        for(int i = 0; i < matrix[row].length; i++){
            //Add the data in the current row and column to the builder
            sb.append("[");
            sb.append(matrix[row][i]);
            //This just makes the output a little nicer, only adds comma if there
            //  is another item to print so there is no trailing comma at the end.
            if(i+1 < matrix[row].length){
                sb.append(",");
                
            }
            sb.append("]");
        }
        //Print the resulting comma separated string
        System.out.println(sb);
    }

    public void testRun() throws InterruptedException {
        //Use an atomic integer to prevent memory consistency issues
        AtomicInteger rowIndex = new AtomicInteger(0);
        ExecutorService ex = Executors.newFixedThreadPool(4);
        for(int i=0 ; i < matrix.length; i++) {
                ex.execute(new Runnable() {
                    @Override
                    public void run() {
                        //Each thread will print a row based on the value
                        // of the atomic integer and will also increment
                        // that integer.
                        printRow(rowIndex.getAndIncrement());
                    }
                });
        }
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("DONE");
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentMatrixPrint a = new ConcurrentMatrixPrint(2,3);
        a.testRun();
    }
}