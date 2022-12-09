class HerramientaMecanica extends Herramienta{
    //Atributos
    private float peso;
    private String tamanio;
    private String dimensiones;
    //Constructor
    HerramientaMecanica(){
        super();
    }
    HerramientaMecanica(String marca,String modelo,int codigo,int costo,float peso,String tamanio,String dimensiones){
        super(marca, modelo, codigo, costo);
        this.setPeso(peso);
        this.setTamanio(tamanio);
        this.setDimensiones(dimensiones);
    }
    @Override
    public void registrar() {
        // TODO Auto-generated method stub
        super.registrar();
        System.out.println("Ingresar peso: ");
        setPeso(leer.nextFloat());
        leer.nextLine();
        System.out.println("Ingresar tamanio: ");
        setTamanio(leer.nextLine());
        System.out.println("Ingresar dimensiones: ");
        setDimensiones(leer.nextLine());
        System.out.println();
    }
    @Override
    public void editar() {
        int opc=0;
        System.out.println("Campo a editar: ");
        System.out.println("1.- Marca: "+getMarca());
        System.out.println("2.- Modelo: "+getModelo());
        System.out.println("3.- Codigo: "+getCodigo());
        System.out.println("4.- Costo: "+getCosto());
        System.out.println("5.- Peso: "+getPeso());
        System.out.println("6.- Tamanio: "+getTamanio());
        System.out.println("7.- Dimensiones: "+getDimensiones());
        System.out.print("Ingrese una opcion: ");
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
            case 5:
                System.out.println("Ingrese nuevo peso: ");
                setPeso(leer.nextFloat());
                System.out.println("Nuevo peso: "+getPeso());
            break;
            case 6:
                System.out.println("Ingrese nuevo tamanio: ");
                setTamanio(leer.nextLine());
                System.out.println("Nuevo tamanio: "+getTamanio());
            break;
            case 7:
                System.out.println("Ingrese nuevas dimensiones: ");
                setDimensiones(leer.nextLine());
                System.out.println("Nuevas dimensiones: "+getDimensiones());
            default: System.out.println("Campo no valido");
        }
        System.out.println();
    }

    @Override
    public void imprimir() {
        // TODO Auto-generated method stub
        super.imprimir();
        System.out.println("Peso: " + getPeso());
        System.out.println("Tamanio: "+getTamanio());
        System.out.println("Dimensiones: "+getDimensiones());
        System.out.println();
    }

    //getters y setters
    public String getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
    public String getTamanio() {
        return tamanio;
    }
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}