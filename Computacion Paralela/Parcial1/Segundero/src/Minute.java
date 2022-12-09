public class Minute extends Thread{
    public static volatile int minute=0;

    @Override
    public void run() {
        while(true){
            if(minute==0)
                System.out.print("00:");
            else if(minute<10)
                System.out.print("0"+minute+":");
            else
                System.out.print(minute+":");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(Segundero.seg==60)
                minute++;
        }

    }
    }

