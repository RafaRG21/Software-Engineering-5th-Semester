import java.util.Random;

public class Cocinero extends Thread {
	private Semaforos cocina;

	public Cocinero(Semaforos cocina) {

		this.cocina = cocina;
	}

	public void run() {
		while (true) {
			Random random = new Random();
			int comida = random.nextInt(20);
			// producer put items
				cocina.cocinar(comida);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
