/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Rafa y beto
 */

public class MiVentana extends JFrame {

    static private BufferedImage buffer;
    //static private Graphics graPixel;
    public MiVentana(){

        setTitle("Mi ventana");
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        //graPixel = (Graphics2D) buffer.createGraphics();

    }

    public static void main(String[] args){
        MiVentana ventana = new MiVentana();

    }

    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }



    public void paint(Graphics g){
        super.paint(g);
        putPixel(100,100,red);
        putPixel(101,100,red);
        putPixel(100,101,red);
        putPixel(101,101,red);

        dibujarLinea(150,200,300,300);

    }
    public void dibujarLinea(float x1, float y1, float x2, float y2){
        float restaX = x2 - x1;
        float restaY = y2 - y1;
        float m = restaY / restaX;
        for(int i =(int) x1; i<(int)x2; i++)
            putPixel(i,(int)(m*(x2-i)+y2),red);


    }//dibujarLinea

}