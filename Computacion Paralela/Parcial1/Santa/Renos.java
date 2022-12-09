/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package santaclaus;

import static java.lang.Thread.sleep;

public class Renos extends Thread{

    CentralAyudantes centralAyudantes;
    
    public Renos(CentralAyudantes centralAyudantes) {
        this.centralAyudantes = centralAyudantes;
    }
    // si santa no esta dispnible se pone a espera
    public synchronized void trineoPartida(){
        while (centralAyudantes.isEstaSanta() == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        //Se amuenta el numero de renos que han regresado
        CentralAyudantes.renos++;
        notifyAll();
    }
    // cuando regresan de repartir se reinicia el contador
    public synchronized void trineoRetorno(){
        CentralAyudantes.renos = 0;
        notifyAll();
    }
    private void renoTrabajo(){
        try {
            trineoPartida();
            System.out.print("Ha regresado un reno... ");
            System.out.println("Renos que han regresado: " + centralAyudantes.getRenos());

            if(centralAyudantes.getRenos() >= 9){
                while (centralAyudantes.isEstaSanta()== false) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                    }
                }
                System.out.println("Han regresado todos los renos");
                System.out.println("Santa ha salido a repartir los regalos con los renos...");
                sleep(6000);
                trineoRetorno();
            }
            if(centralAyudantes.getRenos() == 0){
                System.out.println("Se ha terminado de repartir los regalos. Santa ha regresado y los renos se han ido de vacaciones...");
                sleep(2000);
                if(centralAyudantes.getDuendes() < 3) System.out.println("Se ha ido a dormir Santa");
            }
            sleep(2000);
        } catch (InterruptedException e) { }
    }
    public void run(){
        while(true) {
            renoTrabajo();
        }
    }
}
