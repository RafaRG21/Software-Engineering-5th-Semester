
// Java Program to Demonstrate ExecutorService Interface
 
// Importing requied classes
import java.util.concurrent.*;
 
// Class
// Main class
public class SimpleExecutor {
 
    // Main driver method
    public static void main(String[] args)
    {
        // Creating objects of CountDownLatch class
        
 
        // Creating objects of ExecutorService class
        ExecutorService es
            = Executors.newFixedThreadPool(2);
 
        // Display message only for better readability
        System.out.println("Starting");
 
        // Executing the tasks
        es.execute(new MyThread( "A"));
        es.execute(new MyThread("B"));
        es.execute(new MyThread( "C"));
        es.execute(new MyThread( "D"));
 
        // Try block to check for exceptions
      
 
        // Making all current executing threads to terminate
        es.shutdown();
 
        // Display message only for better readability
        System.out.println("Done");
    }
}
 
// Class 2
// Helper class
class MyThread implements Runnable {
 
    // Class data members
    String name;
    
 
    // Constructor
    MyThread(String name)
    {
 
        // this keyword refers to current instance itself
        this.name = name;
        
 
        new Thread(this);
    }
 
    // Method
    // Called automatically when thread is started
    public void run()
    {
 
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            
        }
    }
}





////////////////////77