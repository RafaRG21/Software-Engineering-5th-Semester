public class Productor extends Thread {

    private int cantidadProducida;

    @Override
    public void run() {

    }
    public void cocinar(){
        synchronized (Main.lock) {
            cantidadProducida = (int) Math.floor(Math.random() * (20 - 1 + 1) + 1);
            while (Main.product > 0) {
                try {
                    Main.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Main.product = cantidadProducida;
            Main.rellenar.notifyAll();
        }
    }
}
