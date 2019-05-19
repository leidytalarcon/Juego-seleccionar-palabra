/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproyect3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tatiana Alarcon
 */
public class ControladorMusica extends Thread {

    VentanaPanel ventana;
    Puntaje puntaje;
    

    public ControladorMusica(VentanaPanel ventana, Puntaje puntaje) {
        this.puntaje = puntaje;
        this.ventana = ventana;
    }

    @Override
    public void run() {
        double duracionCancion=ventana.reproductor.getDuration().getSeconds();
        double tiempoReproducido=0;
        do {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
                System.err.printf(ex.getMessage());
            }

            ventana.cargarOpciones();
            
            tiempoReproducido=ventana.reproductor.getMediaTime().getSeconds();

            synchronized (puntaje) {
                try {
                    //detener el hilo en el cual se encuentra el objeto
                    puntaje.wait();
                } catch (Exception ex) {
                    System.out.println("error hilo");
                }
            }
            
            synchronized(puntaje){
                puntaje.setSegmento(puntaje.getSegmento()+1);
            }

       } while (tiempoReproducido<duracionCancion && puntaje.getSegmento()<=9);
        
        
        
        JOptionPane.showMessageDialog(null, "PUNTAJE: "+puntaje.getPuntaje());
       
       System.exit(0);
        
    }

}
