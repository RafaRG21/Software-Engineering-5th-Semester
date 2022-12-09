public class Producer extends Thread{
    int productQuantity;

    @Override
    public void run() {
        while(true) {
            cooking();
        }
    }

    private void cooking() {
        productQuantity = (int)Math.floor(Math.random()*(20-1+1)+1);
        synchronized (Main.lock){
            while(Main.product>0){
                try {
                    Main.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("Productor: Produciendo");
                Main.product = productQuantity;
                System.out.println("Productor: He producido "+Main.product+" productos.");
                Main.rellenar.notify();

        }
    }
}
