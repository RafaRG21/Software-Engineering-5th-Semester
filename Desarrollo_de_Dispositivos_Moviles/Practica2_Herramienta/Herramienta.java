import java.util.Scanner;

class Herramienta{
    //Atributos
    private String marca;
    private String modelo;
    private int codigo;
    private float costo;
    protected Scanner leer  = new Scanner(System.in);
    //Constructores
    Herramienta(){    
    }
    Herramienta(String marca, String modelo, int codigo, float costo){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCodigo(codigo);
        this.setCosto(costo);
    }
    public void registrar(){       
        System.out.println("Ingresar marca: ");
        setMarca(leer.nextLine());
        System.out.println("Ingresar modelo: ");
        setModelo(leer.nextLine());
        System.out.println("Ingresar codigo: ");
        setCodigo(leer.nextInt());
        System.out.println("Ingresar costo: ");
        setCosto(leer.nextFloat());

    }
    public void editar(){
        int opc=0;
        System.out.println("Campo a editar: ");
        System.out.println("1.- Marca: "+getMarca());
        System.out.println("2.- Modelo: "+getModelo());
        System.out.println("3.- Codigo: "+getCodigo());
        System.out.println("4.- Costo: "+getCosto());
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
                System.out.println("Ingrese nuevo modelo: ");
                setModelo(leer.nextLine());
                System.out.println("Nueva modelo: "+getModelo());
                break;
            case 3:
                System.out.println("Ingrese nuevo codigo: ");
                setCodigo(leer.nextInt());
                System.out.println("Nueva codigo: "+getCodigo());
            break;
            case 4: 
                System.out.println("Ingrese nuevo costo: ");
                setCosto(leer.nextFloat());
                System.out.println("Nuevo costo: "+getCosto());
            break;
            default: System.out.println("Campo no valido");
        }
}
    public void imprimir(){
        System.out.println();
        System.out.println("Informacion de la herramienta: ");
        System.out.println();
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Costo: "+getCosto());
 
    }
    //getters y setters
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}