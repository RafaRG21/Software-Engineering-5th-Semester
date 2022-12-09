

//Puente
//CarroNorte
	
//CarroSur
//GeneradorCarros
			
public class Main{
	public static void main(String[] args){
	
	Puente pu = new Puente();
	CarroNorte cn = new CarroNorte(pu);
	CarroSur cs = new CarroSur(pu);
	GeneradorCarros cola = new GeneradorCarros();
	
	cn.start(); //coches que van de norte-sur
	cs.start(); //coches que van de sur-norte
	cola.start();
	}
}	