

public class Main {

	public static void main(String[] args) {
		final int numCanibales = 5;
        Semaforos semaforo = new Semaforos();
        Cocinero cocinero = new Cocinero(semaforo);
        // Se inicia al cocinero
        cocinero.start();
        Canibal[] canibales = new Canibal[numCanibales];
        for(int i=0;i<numCanibales;i++){
                canibales[i] = new Canibal(semaforo,i+1);
                canibales[i].start();
        }


	}

}
