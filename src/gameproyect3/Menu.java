package gameproyect3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author James Alzate Jr
 */
public class Menu implements ActionListener{
    JFrame windowPrincipal;
    JPanel panel;
    JButton button;
    JLabel title, logo, gif1, gif2, gif3, gif4;
    Font auxFont;
    public Menu() {
        windowPrincipal = new JFrame("Game");
        windowPrincipal.setSize(1058, 600);
        windowPrincipal.setLayout(null);
        windowPrincipal.setLocationRelativeTo(null);
        windowPrincipal.setResizable(false);
        windowPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPrincipal.setVisible(true);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1058,600);
        panel.setBackground(Color.LIGHT_GRAY);
        windowPrincipal.add(panel);
        
        title = new JLabel("ESCOGE LA PALABRA CORRECTA");
        title.setBounds(290, 50, 500, 25);
        auxFont = title.getFont();
        title.setFont(new Font("Comic Sans MS", 0, 30));
        panel.add(title);
        
        imagenes();
        
        button = new JButton("Ingresar");
        button.setBounds(470, 450, 100, 40);
        button.addActionListener(this);
        panel.add(button);
        
        panel.setPreferredSize(new Dimension(0, 500));// se colocan las dimenciones del panel ventana 
        windowPrincipal.add(panel);
        windowPrincipal.add(panel, BorderLayout.NORTH);//pinta el panel en el estremo norte del panel 
    }
    
    public void imagenes(){
        logo = new JLabel();
        logo.setBounds(335,55,400,400);
        panel.add(logo);
        ImageIcon game = new ImageIcon(getClass().getResource("/img/Logo.png"));
        //ImageIcon corporation = new ImageIcon(game.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(game);
        
        gif1 = new JLabel();
        gif1.setBounds(40,70,132,200);
        panel.add(gif1);
        ImageIcon iron = new ImageIcon(getClass().getResource("/img/iron man.gif"));
        gif1.setIcon(iron);
        
        gif2 = new JLabel();
        gif2.setBounds(90,320,198,170);
        panel.add(gif2);
        ImageIcon thor = new ImageIcon(getClass().getResource("/img/thor.gif"));
        gif2.setIcon(thor);
        
        gif3 = new JLabel();
        gif3.setBounds(820,90,180,170);
        panel.add(gif3);
        ImageIcon strange = new ImageIcon(getClass().getResource("/img/doctor strange.gif"));
        gif3.setIcon(strange);
        
        gif4 = new JLabel();
        gif4.setBounds(730,300,278,211);
        panel.add(gif4);
        ImageIcon doom = new ImageIcon(getClass().getResource("/img/doctor doom.gif"));
        gif4.setIcon(doom);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button){
            SeleccionFrame seleccion = new SeleccionFrame();
            windowPrincipal.setVisible(false);
            seleccion.setVisible(true);
        }
    }
    
}
