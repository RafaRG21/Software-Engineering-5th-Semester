public class Hilo1 extends Thread {


    @Override
    public void run(){
                for (int i = 0; i < 3; i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < 3; j++) {
                            Matriz.matriz[i][j] *= 2;
                        }
                    }
                }


    }
}

