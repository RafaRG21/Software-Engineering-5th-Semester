


public class Canibal extends Thread {
	private Semaforos comedor;
	private int id;
	public Canibal(Semaforos comedor,int id) {
		this.id  = id;
		this.comedor = comedor;
	}

	public void run() {
		while (true) {
			// consumer get items
			comedor.comer(this.id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}