public class Trailer extends Vehiculo{
    //Atributos
    private int peso;
    private int llantas;
    private int remolques;
    private int capacidad;
    
    //Constructores
    Trailer(){
    }
    public Trailer(String marca, String color, int numAsientos, int velocidad, int peso, int llantas, int remolques,
			int capacidad) {
		super(marca, color, numAsientos, velocidad);
		this.peso = peso;
		this.llantas = llantas;
		this.remolques = remolques;
		this.capacidad = capacidad;
	}
	
    //metodos
    @Override
    public void registrar() {
        // TODO Auto-generated method stub
        super.registrar();
        System.out.println("Ingresar peso: ");
        setPeso(leer.nextInt());
        System.out.println("Ingresar numero de llantas: ");
        setLlantas(leer.nextInt());
        System.out.println("Ingresar numero de remolques: ");
        setRemolques(leer.nextInt());
        System.out.println("Ingresar capacidad de carga: ");
        setCapacidad(leer.nextInt());
    }
    @Override
    public void editar() {
        int opc=0;
        System.out.println("Campo a editar: ");
        System.out.println("1.- Marca: "+getMarca());
        System.out.println("2.- Color: "+getColor());
        System.out.println("3.- Numero de Asientos: "+getNumAsientos());
        System.out.println("4.- Velocidad: "+getVelocidad());
        System.out.println("5.- Peso: "+getPeso());
        System.out.println("6.- Numero de llantas: "+getLlantas());
        System.out.println("7.- Numero de remolques: "+getRemolques());
        System.out.println("8.- Capacidad de carga: "+getCapacidad());
        System.out.print("Opcion a elegir: ");
        opc = leer.nextInt();
        leer.nextLine();
        switch(opc){
            case 1: 
                System.out.println("Ingrese nueva marca: ");
                setMarca(leer.nextLine());
                System.out.println("Nueva marca: "+getMarca());
                break;
            case 2:
                System.out.println("Ingrese nuevo color: ");
                setColor(leer.nextLine());
                System.out.println("Nueva color: "+getColor());
                break;
            case 3:
                System.out.println("Ingrese nuevo numero de asientos: ");
                setNumAsientos(leer.nextInt());
                System.out.println("Nueva numero de asientos: "+getNumAsientos());
            break;
            case 4: 
                System.out.println("Ingrese nueva velocidad: ");
                setVelocidad(leer.nextInt());
                System.out.println("Nueva velocidad: "+getVelocidad());
            break;
            case 5: 
                System.out.println("Ingrese nuevo peso: ");
                setPeso(leer.nextInt());
                System.out.println("Nuevo peso: "+getPeso());
            break;
            case 6: 
                System.out.println("Ingrese nuevo numero de llantas: ");
                setLlantas(leer.nextInt());
                System.out.println("Nuevo numero de llantas: "+getLlantas());
            break;
            case 7: 
                System.out.println("Ingrese nuevo numero de remolques: ");
                setRemolques(leer.nextInt());
                System.out.println("Nuevo numero de remolques: "+getRemolques());
            break;
            case 8: 
                System.out.println("Ingrese nueva capacidad de carga: ");
                setCapacidad(leer.nextInt());
                System.out.println("Nueva capacidad de carga: "+getCapacidad());
            break;
            default: System.out.println("Campo no valido");
        }
    }
    @Override
    public void imprimir() {
        // TODO Auto-generated method stub
        super.imprimir();
        System.out.println("Peso: "+getPeso());
        System.out.println("Numero de Llantas: "+getLlantas());
        System.out.println("Numero de Remolques: "+getRemolques());
        System.out.println("Capacidad de Carga: "+getCapacidad());
    }

    //getters y setters
	public int getPeso() {
		return peso;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getRemolques() {
		return remolques;
	}
	public void setRemolques(int remolques) {
		this.remolques = remolques;
	}
	public int getLlantas() {
		return llantas;
	}
	public void setLlantas(int llantas) {
		this.llantas = llantas;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
    
    
}
