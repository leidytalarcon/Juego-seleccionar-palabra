package gameproyect3;

import Archivos.GestionarArchivo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.edisoncor.gui.button.ButtonAqua;

/**
 *
 * @author James Alzate Jr
 */
public class VentanaPanel extends JPanel implements KeyListener{
    
    JLabel character, title;
    int x,y;
    Font auxFont;
    
    ButtonAqua button1, button2, button3, button4;
    
    ImageIcon iron;
    ImageIcon imgFondo ;
    Player reproductor;
    Puntaje puntaje;
    
    ArrayList<Integer> posicionBotones=new ArrayList<>();
    Boolean estadoCancion=true;
 
    public VentanaPanel(URL urlIron,URL fondo,Puntaje puntaje){
        
        iron= new ImageIcon(urlIron);
        imgFondo= new ImageIcon(fondo);
        this.puntaje=puntaje;
        
        this.setSize(1058, 600);
        this.setLayout(null);
        this.setVisible(true);

        x = 470;
        y = 350;
        setDoubleBuffered(true);
        character = new JLabel();
        character.setBounds(x,y,132,200);
        this.add(character);
        
        //ImageIcon man = new ImageIcon(iron.getImage().getScaledInstance(gif1.getWidth(), gif1.getHeight(), Image.SCALE_DEFAULT));
        character.setIcon(iron);
        addKeyListener(this);
        setFocusable(true);
        
        title = new JLabel("HOLD BACK");
        title.setBounds(450,50,200,35);
        auxFont = title.getFont();
        title.setForeground(Color.WHITE);
        title.setFont(new Font(null,0,35));
        this.add(title);
        
        precargaPosiciones();
        
        button1 = new ButtonAqua();
        button1.setLabel("Hola");
        button1.setBackground(Color.yellow);
        button1.setBounds(posicionBotones.get(0),posicionBotones.get(1),150,50);
        button1.addActionListener(new ActionListener() {
            //metodo que se ejecutara cuando se le de click al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = 0;
                
                
                validarRespuesta(opcion);
            }
        });
        this.add(button1);
        
        
        button2 = new ButtonAqua();
        button2.setLabel("Hola");
        button2.setBackground(Color.CYAN);
        button2.setBounds(posicionBotones.get(2),posicionBotones.get(3),150,50);
        button2.addActionListener(new ActionListener() {
            //metodo que se ejecutara cuando se le de click al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = 1;
                
                
                validarRespuesta(opcion);
            }
        });
        this.add(button2);
        
        button3 = new ButtonAqua();
        button3.setLabel("Hola");
        button3.setBackground(Color.MAGENTA);
        button3.setBounds(posicionBotones.get(4),posicionBotones.get(5),150,50);
        button3.addActionListener(new ActionListener() {
            //metodo que se ejecutara cuando se le de click al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = 2;
                
                
                validarRespuesta(opcion);
            }
        });
        this.add(button3);
        
        button4 = new ButtonAqua();
        button4.setLabel("Hola");
        button4.setBackground(Color.RED);
        button4.setBounds(posicionBotones.get(6),posicionBotones.get(7),150,50);
        button4.addActionListener(new ActionListener() {
            //metodo que se ejecutara cuando se le de click al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = 3;
                
                
                validarRespuesta(opcion);
            }
        });
        this.add(button4);
        
          try {
           //buscar ruta del archivo de la caancion, la libreria solo permite archivos de audio .wav 
            URL url = new URL(this.getClass().getResource("/sound/video3.wav").toString());  
            
            //buscar el archivo de audio en la url especificada
            //Manager envia esta cancion al reproductor de audio
            reproductor = Manager.createRealizedPlayer(url);

        } catch (Exception ex) {
            System.err.printf("error"+ex);
        }
        
          ocultarOpciones();
        //le dice al reproductor que inicie la cancion
        reproductor.start();
       
    }
    
    private void precargaPosiciones(){
        posicionBotones.add(100);
        posicionBotones.add(150);
        
        posicionBotones.add(340);
        posicionBotones.add(150);
        
        posicionBotones.add(570);
        posicionBotones.add(150);
        
        posicionBotones.add(810);
        posicionBotones.add(150);
    }
    
    public void ocultarOpciones(){
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        
    }
    
    public void mostrarOpciones(){
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        
    }
    
    public void cargarOpciones(){
        GestionarArchivo archivos=new GestionarArchivo();
        ArrayList<String> opciones=archivos.LeerOpciones();
        
        int segmento=puntaje.getSegmento();
        
        button1.setText(opciones.get(segmento*4));
        button2.setText(opciones.get(segmento*4+1));
        button3.setText(opciones.get(segmento*4+2));
        button4.setText(opciones.get(segmento*4+3));
        
        estadoCancion=false;
        mostrarOpciones();
        
        reproductor.stop();
        
    }
    
    @Override
    public void paintComponent (Graphics g){
        Dimension tamanio = getSize();
       
        g.drawImage(imgFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        
        if (key == KeyEvent.VK_UP){ //Mover personaje hacia arriba
            if(y > 0 + 5){
                y -= 10;
                character.setBounds(x,y,132,200);
            }
        }
        
        if(key==KeyEvent.VK_DOWN){ //Mover el personaje hacia abajo
            if(y<500-130){
                y+=10;
                character.setBounds(x,y,132,200);
            }   
        }
        
        if (key==KeyEvent.VK_RIGHT){//Mover el personaje hacia la derecha
            if(x<900){
                x+=10;
                character.setBounds(x,y,132,200);
            }
        }
        
        if(key==KeyEvent.VK_LEFT){//Mover el personaje hacia la izquierda
            if(x>0+5){
                x-=10;
                character.setBounds(x,y,132,200);
            }
        }
        
       if(!estadoCancion)
       {
         
               if(y>150 && y<170){
                   if(x>100 && x<150){validarRespuesta(0);}
                       
                       if(x>340 && x<390){validarRespuesta(1);}
                           
                           if(x>570 && x<620 ){validarRespuesta(2);}
                               
                               if(x>810 && x<860 ){validarRespuesta(3);}
               }
               
        
       }
           
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println(KeyEvent.getKeyText(ke.getKeyCode()));
    }
    
     public void validarRespuesta(int opcion) {
         
        //saber en que segmento va la cancion
        int segmentoActual = puntaje.getSegmento();
        
        //conoer la respuesta correcta para el segmento en el cual va la cancion
        GestionarArchivo archivos=new GestionarArchivo();
        ArrayList<Integer> respuestas=archivos.LeerRespuestas();
        
        int respuestaActual = respuestas.get(segmentoActual);
        
        //validar si la opcion elegida coincide con la repsuesta correcta
        if (opcion == respuestaActual) {

            //mostrar panel de confirmacion
            JOptionPane.showMessageDialog(null, "CORRECTO");
            //añadirle un punto al usuario en caso de repsuesta correcta
            puntaje.setPuntaje(puntaje.getPuntaje() + 1);
            

        } else {

            JOptionPane.showMessageDialog(null, "INCORRECTO");

        }
        
        //ocultar labels que solos e muestran cada que se detiene la cancion
        estadoCancion=true;
        ocultarOpciones();
        reproductor.start();

        synchronized (puntaje) {//ya que puntaje es una instancia compartida entre dos hilos
                //es obligatorio usar sincronize para que solo pueda ser usado por una clase a la vez y evitar errores
                //en caso de ser llamado por varias clases al tiempo se crea una cola de espera
            
            //decirle al hilo que se enceuntra pausado en MusicaController que continue
            puntaje.notifyAll();
        }
     }
    
   
}
