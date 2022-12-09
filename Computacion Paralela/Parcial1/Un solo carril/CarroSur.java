class CarroSur extends Thread{
	private Puente puente;
	public CarroSur(Puente puente) {

		this.puente = puente;
	}
	
	public void run(){
		while(true)
		{
			puente.sur();
		
			try {
				sleep(1000 );
			}
			catch(InterruptedException e)
			{ System.out.println("Error "+e.toString()); }
		}
		}
	}