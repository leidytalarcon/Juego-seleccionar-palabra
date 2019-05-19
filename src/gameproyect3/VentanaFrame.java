package gameproyect3;

import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author James Alzate Jr
 */
public class VentanaFrame extends JFrame{
    URL personaje;
    URL fondo;
    
    public VentanaFrame(URL personaje,URL fondo ){
        super("Game");
        
        fondo=fondo;
        personaje=personaje;
        
        Puntaje puntaje=new Puntaje();
        VentanaPanel IronManP = new VentanaPanel(personaje,fondo, puntaje);
        ControladorMusica musica=new ControladorMusica(IronManP,puntaje);
        musica.start();
        
        
        this.setSize(1058, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(IronManP);
    }
}
