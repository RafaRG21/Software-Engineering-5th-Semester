class GeneradorCarros extends Thread{
	int carroNuevo;
	int cola;
	private void nuevoCarro(){
        //Se añaden coches a la cola de manera aleatoria cada cierto tiempo
		 cola = (int)Math.floor(Math.random()*(2-1+1)+1);
		if(cola == 1) {
			Puente.cochesNorte++;
			System.out.println("--------Nuevo carro en la cola norte... Hay "+Puente.cochesNorte+" carros en el norte---------");
		}
		if(cola == 2) {
			Puente.cocheSur++;
			System.out.println("--------Nuevo carro en la cola sur... Hay "+Puente.cocheSur+" carros en el sur---------");
		}

	}

	@Override
	public void run() {
        
	while (true) {
		nuevoCarro();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}