package santaclaus;

public class CentralAyudantes {

    public static volatile int duendes = 0;
    public static volatile int renos = 0;
    private boolean estaSanta = true;

    //getters y setters
    public int getDuendes() {
        return duendes;
    }

    public void setDuendes(int duendes) {
        this.duendes = duendes;
    }

    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public boolean isEstaSanta() {
        return estaSanta;
    }

    public void setEstaSanta(boolean estaSanta) {
        this.estaSanta = estaSanta;
    }

}
