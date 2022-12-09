/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package santaclaus;



public class Main {


    public static void main(String[] args) throws InterruptedException{


        CentralAyudantes central = new CentralAyudantes();
        Santa santaclaus = new Santa(central);
        Renos reno = new Renos(central);
        Duendes duende = new Duendes(central);

        
        santaclaus.start();
        reno.start();
        duende.start();

        
    }
    
}
