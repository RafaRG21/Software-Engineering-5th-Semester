import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.activeCount;

public class Main {
    public static void main(String[] args) {
        Hilo hilo = new Hilo("Juan");
        System.out.print("Start: ");//start
        hilo.start();
        //join
        try {
            hilo.join();
            hilo.setPriority(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Active Count: "+activeCount());//Active Count
        hilo.checkAccess(); //checkAccess
        Hilo hilo2 = new Hilo("Pedro");
        //Run
        System.out.print("Run: ");
        hilo2.run(); //Run
        //getId
        System.out.println("getId: "+hilo.getId());
        //getContextClassLoader
        System.out.println("getContextClassLoader: "+hilo.getContextClassLoader());
        //setName
        hilo.setName("NombreHilo");
        //getName
        System.out.println("getName: "+hilo.getName());
        //setPriority
        hilo2.setPriority(MAX_PRIORITY);
        //getPrority
        System.out.println("getPriority: "+hilo2.getPriority());
        //getStackTrace
        System.out.println("getStackTrace: "+hilo.getStackTrace());
        //getState
        System.out.println("getState: "+hilo.getState());
        //Sleep
        System.out.println("Sleep: ");
        try {
            hilo.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Este hilo esta vivo?: ");
        if(hilo.isAlive()){
            System.out.println(hilo.isAlive());
        }else System.out.println(hilo.isAlive());
        //interrupt
        System.out.println("Interrumpiendo hilo: ");
        hilo2.interrupt();
        //isInterrupted
        System.out.println("Esta interrumpido? "+hilo2.isInterrupted());
        //getState
        System.out.println("State: "+ hilo2.getState());
        //getThreadGroup
        System.out.println("getThreadGroup:"+hilo.getThreadGroup());
        //getUncaughtExceptionHandler
        System.out.println("getUncaughtExceptionHandler: "+hilo.getUncaughtExceptionHandler());
        //setDaemon
        hilo.setDaemon(true);
        //isDaemon
        System.out.println("isDaemon: " + hilo.isDaemon());
        hilo.setDaemon(false);
        //toString
        System.out.println("toString: "+hilo.toString());
        //equals
        System.out.println("hilo equals hilo2:"+hilo.equals(hilo2));
        //hashCode
        System.out.println("hashCode: "+hilo.hashCode());
        System.out.println("getClass: "+hilo.getClass());
    }
}
