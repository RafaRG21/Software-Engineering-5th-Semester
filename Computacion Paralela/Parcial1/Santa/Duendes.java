/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package santaclaus;

import static java.lang.Thread.sleep;


public class Duendes extends Thread {

    CentralAyudantes centralAyudantes;

    public Duendes(CentralAyudantes centralAyudantes) {

        this.centralAyudantes = centralAyudantes;
    }
    public synchronized void duendesAyudados(){
        CentralAyudantes.duendes-=3;
        notifyAll();
    }
    public synchronized void duendeAprieto() {
        CentralAyudantes.duendes++;
        notifyAll();
    }
    private void duendeTrabajo(){
        try {
            duendeAprieto(); //  se aumenta el numero de duendes en aprietos
            System.out.println("Duendes en problemas: " + centralAyudantes.getDuendes());
            if (centralAyudantes.getDuendes() >= 3 && centralAyudantes.getRenos() < 9) {
                System.out.println("Los duendes han despertado a Santa...");
                sleep(2000);
                System.out.println("Santa ha ayudado a 3 duendes...");
                if (centralAyudantes.getDuendes() < 3) {
                    System.out.println("Santa regresara a dormir...");
                }
                duendesAyudados();
            }
            sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    public void run() {
        while (true) {
            duendeTrabajo();
        }
    }
}
