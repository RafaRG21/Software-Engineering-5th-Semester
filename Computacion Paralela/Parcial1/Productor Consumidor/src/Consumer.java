public class Consumer extends Thread{
    private int num;
    Consumer(int num){
        this.num = num;
    }
    @Override
    public void run() {
        while(true) {
            consuming();
        }
    }

    private void consuming() {
        synchronized (Main.lock){
                while(Main.product == 0){
                    System.out.println("Consumidor "+this.num+": Productor despierta no hay productos!!!");
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consumidor "+this.num+": consumiendo...");
                Main.product--;
                System.out.println("Consumidor "+this.num+": Quedan " + Main.product+" productos.");


        }
    }
}
