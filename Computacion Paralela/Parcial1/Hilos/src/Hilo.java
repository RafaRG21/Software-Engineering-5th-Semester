public class Hilo extends Thread {
    String name;

    Hilo(String name){
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        System.out.println("Hola "+name+"!!!");
    }


}
