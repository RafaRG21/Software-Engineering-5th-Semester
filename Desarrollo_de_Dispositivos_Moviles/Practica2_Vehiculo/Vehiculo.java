import java.util.Scanner;

class Vehiculo{
    //Atributos
    private String marca;
    private String color;
    private int numAsientos;
    private int velocidad;
    protected Scanner leer  = new Scanner(System.in);
    //Constructor
    Vehiculo(){
    }
    public Vehiculo(String marca, String color, int numAsientos, int velocidad) {
		this.marca = marca;
		this.color = color;
		this.numAsientos = numAsientos;
		this.velocidad = velocidad;
	}
	//Métodos
    
    public void registrar(){       
        System.out.println("Ingresar marca: ");
        setMarca(leer.nextLine());
        System.out.println("Ingresar color: ");
        setColor(leer.nextLine());
        System.out.println("Ingresar numero de asientos: ");
        setNumAsientos(leer.nextInt());
        System.out.println("Ingresar velocidad: ");
        setVelocidad(leer.nextInt());

    }
    public void editar(){
        int opc=0;
        System.out.println("Campo a editar: ");
        System.out.println("1.- Marca: "+getMarca());
        System.out.println("2.- Color: "+getColor());
        System.out.println("3.- Numero de Asientos: "+getNumAsientos());
        System.out.println("4.- Velocidad: "+getVelocidad());
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
                System.out.println("Ingrese nuevA velocidad: ");
                setVelocidad(leer.nextInt());
                System.out.println("Nueva velocidad: "+getVelocidad());
            break;
            default: System.out.println("Campo no valido");
        }
    }
    public void imprimir(){
        System.out.println();
        System.out.println("Informacion del Vehiculo: ");
        System.out.println();
        System.out.println("Marca: "+getMarca());
        System.out.println("Color: "+getColor());
        System.out.println("Numero de Asientos: "+getNumAsientos());
        System.out.println("Velocidad: "+getVelocidad());
 
    }

    //Setters y getters
	public String getMarca() {
		return marca;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getNumAsientos() {
		return numAsientos;
	}
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
    

}