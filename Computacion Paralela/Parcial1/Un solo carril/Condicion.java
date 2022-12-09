public class Condicion { // not yet implemented
	//Pone en espera al objeto cerradura
	public void waitC(Object monitor) {
		try{
			monitor.wait();
		}
		catch(InterruptedException e){System.out.println("Error: "+e.toString());}
	}
	//notifica a un objeto para que se ejecute
   public void notifyC(Object monitor) {

		monitor.notify();
	}

}
