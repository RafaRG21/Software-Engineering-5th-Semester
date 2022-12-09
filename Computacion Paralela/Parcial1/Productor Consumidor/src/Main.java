public class Main {
    static volatile int product=0;
    static Object lock = new Object();
    static Object rellenar = new Object();


    public static void main(String[] args){
        Producer producer = new Producer();
        Consumer consumer1 = new Consumer(1);
        Consumer consumer2 = new Consumer(2);
        Consumer consumer3 = new Consumer(3);
        Consumer consumer4 = new Consumer(4);
        Consumer consumer5 = new Consumer(5);

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();

    }
}
