import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class mainClass
{
    int row1;
    int col1;

    int row2;
    int col2;

    int A[][];
    int B[][];

    int C[][];
    int D[][];


    mainClass()
    {
        row1=1000;
        col1=1000;

        row2=1000;
        col2=1000;

        A= new int [row1][col1];
        B= new int [row2][col2];        
        C= new int [row1][col2];
        D= new int [row1][col2];

    }
    public static void main(String args[])
    {
        mainClass ob = new mainClass();
        int c=0;

        for(int i=0;i<ob.row1;i++)
        {
            for(int j=0;j<ob.col1;j++)
            {
                ob.A[i][j]=c++;
            }
        }

        c=0;

        for(int i=0;i<ob.row2;i++)
        {
            for(int j=0;j<ob.col2;j++)
            {
                ob.B[i][j]=c++;
            }
        }
        /*** Commented Below code as printing huge matrix takes long time ***/

        //System.out.print(" \nPrint Matrix A:\n\n");
        //ob.printMatrix(ob.A);
        //System.out.print(" \nPrint Matrix B:\n\n");
        //ob.printMatrix(ob.B);
        ob.matrixMulUtility();
    }

    public void matrixMulUtility()
    {
        long startTime = System.currentTimeMillis();

    // This method is for matrix multiplication without multithreading  
        matrixMultiply(); 
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(" \nExecution time of matrixMultiply function is : "+ elapsedTime +"ms\n");

/*** Commented Below code as printing huge matrix takes long time ***/

        //System.out.print(" \nPrint Matrix C without multithreading:\n\n");
        //printMatrix( C);



/*** Below code is for matrix multiplication using multithreading ****/


        try{

        ExecutorService executor = Executors.newFixedThreadPool(this.col2);
        startTime = System.currentTimeMillis();
        for(int i=0;i<row1;i++)
        {
            for(int j=0;j<col2;j++)
            {
                RunnableClass ob = new RunnableClass(i,j,this);
                executor.execute(ob);
            }
        }

         executor.shutdown();
         while (!executor.isTerminated()) {
        }
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println(" \nExecution time of matrixMultiply function  using multithreadingis : "+ elapsedTime +"ms\n");
        }catch(Exception e)
        {

        }

        /*** Commented Below code as printing huge matrix takes long time ***/

        //System.out.print(" \nPrint Matrix D with multithreading:\n\n");
        //printMatrix( D);

    }
/** Non-Threaded Matrix multiplication function  **/

    void matrixMultiply()
    {
        for(int i=0;i<row1;i++)
        {
            for(int j=0;j<col2;j++)
            {
                for(int k=0;k<row2;k++)
                {
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }



    }

    void printMatrix(int ar[][])
    {
        int row=ar.length;
        int col=ar[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(" "+ar[i][j]);
            }
            System.out.print("\n");

        }
    }
}


/*** Runnable class for mutlithreaded matrix multiplication  ***/

class RunnableClass implements Runnable
{
    int i,j;
    mainClass ob;


    RunnableClass(int ii,int jj,mainClass ob1)
    {

        i=ii;
        j=jj;
        ob=ob1;

    }

    /*** Below code of run method is performing matrix multiplication for Each cell  and placing output in the resultant
        matrix D  ***/  

     public void run()
    {

        int sum=0;

        for(int k=0;k<ob.row2;k++)
        {

            sum+=ob.A[i][k]*ob.B[k][j];
        }

        ob.D[i][j]=sum;

    }
}