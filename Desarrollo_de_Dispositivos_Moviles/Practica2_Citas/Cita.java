import java.util.Scanner;

class Cita{
    //Atributos
    private String fecha;
    private String hora;
    private String lugar;
    private Scanner leer = new Scanner(System.in);
    //Constructor generico
    Cita(){

    }
    //Constructor personalizado
    Cita(String fecha,String hora,String lugar){
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    public void registrar(){       
        System.out.println("Ingresar fecha: ");
        setFecha(leer.nextLine());
        System.out.println("Ingresar hora: ");
        setHora(leer.nextLine());
        System.out.println("Ingresar lugar: ");
        setLugar(leer.nextLine());
        System.out.println("Registro realizado!");
        System.out.println();
    }
    public void editar(){
            int opc=0;
            System.out.println("Campo a editar: ");
            System.out.println("1.- Fecha: "+getFecha());
            System.out.println("2.- Hora: "+getHora());
            System.out.println("3.- Lugar: "+getLugar());
            opc = leer.nextInt();
            leer.nextLine();
            switch(opc){
                case 1: 
                    System.out.println("Ingrese nueva fecha: ");
                    setFecha(leer.nextLine());
                    System.out.println("Nueva fecha: "+getFecha());
                    break;
                case 2:
                    System.out.println("Ingrese nueva hora: ");
                    setHora(leer.nextLine());
                    System.out.println("Nueva hora: "+getHora());
                    break;
                case 3:
                    System.out.println("Ingrese nuevo lugar: ");
                    setLugar(leer.nextLine());
                    System.out.println("Nueva lugar: "+getLugar());
                break;
                default: System.out.println("Campo no valido");
            }
    }
    public void imprimir(){
        System.out.println();
        System.out.println("Informacion de la cita: ");
        System.out.println();
        System.out.println("Fecha: "+getFecha());
        System.out.println("Hora: "+getHora());
        System.out.println("Lugar: "+getLugar());
        System.out.println();
        
    }
    //getters y setters
    public String getFecha(){
        return this.fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getHora(){
        return this.hora;
    }
    public void setHora(String hora){
        this.hora = hora;
    }
    public String getLugar(){
        return this.lugar;
    }
    public void setLugar(String lugar){
        this.lugar = lugar;
    }
   

}