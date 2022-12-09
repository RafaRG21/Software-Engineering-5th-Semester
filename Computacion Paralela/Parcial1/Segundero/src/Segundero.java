public class Segundero extends Thread{
    public static volatile int seg=0;

    @Override
    public void run() {
        while(true){
            if(seg==0)
                System.out.println("00");
            else if(seg<10)
                System.out.println("0"+seg);
            else
                System.out.println(seg);
            seg++;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(seg>=60)
                seg=0;
        }

        }
    }

