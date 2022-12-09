public class Hilo2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if(i%2!=0) {
                for (int j = 0; j < 3; j++) {
                    Matriz.matriz[i][j] *= 2;
                }
            }
        }
    }
}
