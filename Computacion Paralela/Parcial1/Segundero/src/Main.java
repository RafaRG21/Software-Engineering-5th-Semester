public class Main {

    public static void main(String[] args) {
        Segundero second = new Segundero();
        Minute minute = new Minute();
        Hour hour = new Hour();
        hour.start();
        minute.start();
        second.start();
        hour.setPriority(10);
        minute.setPriority(7);
        second.setPriority(6);
        try{
            hour.join();
            minute.join();
            second.join();
        }catch (Exception e){}
    }
}
