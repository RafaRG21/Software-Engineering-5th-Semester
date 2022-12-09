

class Puente extends Cerradura{ // Region Critica
	private int paso; // variable para bloquear el paso a los autos
	public static volatile int cochesNorte,cocheSur; //Numero de carros en cada extremos
	private Condicion MutexN = null;
	private Condicion MutexS = null;
	//Constructor
	public Puente() {
		paso = (int)Math.floor(Math.random()*(2-1+1)); // Para que pase de manera aleatoria en el prime carro
		//numero de coches de inicio
        cochesNorte=4;
		cocheSur=4;
		MutexN = new Condicion();
		MutexS = new Condicion();
	}

	//Funciones
	public synchronized void norte(){
        //Si el puente esta bloqueado para los coches del norte-sur se ponen en espera
		while(paso != 0)
		{
			wait(MutexN);
		}
        //Se disminuye la cola
		cochesNorte--;
		System.out.println("Coche pasando... del norte al sur quedan "+cochesNorte+" carros");

		if(cochesNorte<1){

			System.out.println("Han pasado todos los carros del norte al sur ...espere por favor");
			paso=1;
			cochesNorte = 0;
			notify(MutexS);
		}
	}

	public synchronized void sur(){
        //Si el puente esta bloqueado para los coches del sur-norte se ponen en espera
		while(paso == 0){
			wait(MutexS);
		}
		cocheSur--;
		System.out.println("Coche   pasando...del sur al norte quedan "+cocheSur+" carros");
		if(cocheSur<1) {
			cocheSur = 0;
			System.out.println("Han pasado todos los carros del sur al norte ...espere por favor");
			paso=0;
			notify(MutexN);
		}
	}
} // fin_clase