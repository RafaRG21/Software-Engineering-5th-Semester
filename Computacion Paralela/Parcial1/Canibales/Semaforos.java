
import java.util.concurrent.Semaphore;

public class Semaforos {
	private int olla;
	boolean disponibilidadComida = true;
    private int ordenHilos = 1;
	//Semaforos
	private Semaphore semaforoCanibal = new Semaphore(0);
	private Semaphore semaforoCocinero = new Semaphore(1);

	// Metodo comer
	public synchronized void comer(int id) {
        //Para que los canibales coman en orden
    while(id!=ordenHilos) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        if (olla > 0) {
            try {
                //Se solicita el permit al semaforo para comer de uno en uno
                semaforoCanibal.acquire();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

            // consumer consuming an item
            this.olla--;
            System.out.print("Canibal "+id+": comiendo...");
            System.out.println(" quedan: " + olla+" alimentos en la olla.");


            disponibilidadComida = true;
        } else {
            if (disponibilidadComida)
                System.out.println("Canibal " + id + ": Cocinero despierta ya no hay comida en la olla!!! ");
            disponibilidadComida = false;
            //Se notifica al cocinero que no hay comida
            semaforoCocinero.release();

        }
        ordenHilos++;
        if(ordenHilos>5)
                ordenHilos = 1;
        notifyAll();

	}

	// Metodo cocinar
	public  void cocinar(int olla) {
		if(this.olla==0) {
			try {
				// Se cierra el semaforo para cocinar
				semaforoCocinero.acquire();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}

			// Se produce mas comida
			this.olla = olla;
            System.out.print("Cocinero: Cocinando...");
			System.out.println(" He cocinado " + olla+" alimentos en la olla.");
            //Se notifica al canibal que ya hay comida
			semaforoCanibal.release();
		}
		//Se notifica al canibal que sigue habiendo comida
		else
			semaforoCanibal.release();
	}
}
