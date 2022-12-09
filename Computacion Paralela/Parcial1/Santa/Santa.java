/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package santaclaus;


public class Santa extends Thread{

    CentralAyudantes centralAyudantes;
    
    public Santa(CentralAyudantes centralAyudantes) {
        this.centralAyudantes = centralAyudantes;
    }

    private void tareasDisponibles(){
        if(centralAyudantes.getRenos() < 9)
            centralAyudantes.setEstaSanta(true);
        else
            centralAyudantes.setEstaSanta(false);

    }
    public void run(){
        tareasDisponibles();
        }
}
