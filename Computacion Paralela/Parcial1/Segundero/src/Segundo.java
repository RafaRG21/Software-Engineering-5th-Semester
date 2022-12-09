public class Segundo extends Thread {
    int sec = 00;
    int minute = 00;
    int hour= 00;

    @Override
    public void run() {
        while(true){
            if(sec==0&&minute==0&&hour==0)
                System.out.println("00:00:00");

        }
    }
}
