public class Hour extends Thread{
    int hour = 0;

    @Override
    public void run() {
        while(true){
            if(hour==0)
                System.out.print("00:");
            else if(hour<10)
                System.out.print("0"+hour+":");
            else
                System.out.print(hour+":");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(Minute.minute==60)
                hour++;
        }
    }
}
