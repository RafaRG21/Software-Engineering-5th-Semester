public class Matriz {

    public volatile static int matriz[][];

    public static void imprimir(int m[][]){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        matriz= new int[3][3];
        Hilo1 hilo1 = new Hilo1();
        Thread hilo2 = new Thread(new Hilo2());
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matriz[i][j] = (int)Math.floor(Math.random()*(100-1+1))+1;

            }
        }
        System.out.println("Matriz Original:");
        imprimir(matriz);

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Matriz Multiplicada");
        imprimir(matriz);


    }

}
