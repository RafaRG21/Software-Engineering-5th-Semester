import java.lang.Object;
import java.lang.Thread;
import java.io.*;

class PuenteEstrecho{

    boolean used;

    PuenteEstrecho(){
        used = false;
    }

    public synchronized void pasar (String sentido){

        System.out.println("Un carro en sentido" +sentido+ "esta pasando.");
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){}
        System.out.println("El carro en sentido"+sentido+ " ya paso");
    }
}

class Carros extends Thread{
    String sentido;
    PuenteEstrecho rec;

    Carros(String l, PuenteEstrecho p){
        sentido = l;
        rec = p;
    }

    public void run(){

        int i=0;
        while(i<0){
                        /*while(re.used ==true){
                                   try{
                                               wait()
                                   } catch(InterruptedException e){}
                        }*/
            rec.pasar(sentido);
            i++;
        }
    }
}


class Test{
    public static void main(String args[]){
        PuenteEstrecho p= new PuenteEstrecho();
        Carros Norte=new Carros("Norte",p);
        Carros Sur=new Carros("Sur",p);

        Norte.start();
        Sur.start();

        try{

            Norte.join();
            Sur.join();
        }catch(InterruptedException e){}
    }
}