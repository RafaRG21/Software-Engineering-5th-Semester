class CarroNorte extends Thread{
	private Puente puente;
	public CarroNorte(Puente puente) {

		this.puente = puente;
	}
	
	public void run(){
		while (true)
		{
			 puente.norte();

		
			try {
				sleep( 1000 );
			}
			catch(InterruptedException e)
			{
				System.out.println("Error "+e.toString());
			}
			
		}
		}
	}