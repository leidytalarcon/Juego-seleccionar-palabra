package gameproyect3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.edisoncor.gui.button.ButtonAqua;

/**
 *
 * @author Tatiana Alarcon
 */
public class SeleccionPanel extends JPanel implements ActionListener {

    JLabel title, gif1, gif2, gif3, gif4;
    Font auxFont;
    ButtonAqua button1, button2, button3, button4;

    public SeleccionPanel() {
        this.setSize(1058, 600);
        this.setLayout(null);
        this.setVisible(true);

        title = new JLabel("SELECCIONA TU PERSONAJE");
        title.setBounds(290, 50, 500, 25);
        auxFont = title.getFont();
        title.setFont(new Font("Comic Sans MS", 0, 30));
        title.setForeground(Color.WHITE);
        this.add(title);

        gif1 = new JLabel();
        gif1.setBounds(40, 70, 132, 200);
        this.add(gif1);
        ImageIcon iron = new ImageIcon(getClass().getResource("/img/iron man.gif"));
        gif1.setIcon(iron);

        gif2 = new JLabel();
        gif2.setBounds(90, 320, 198, 170);
        this.add(gif2);
        ImageIcon thor = new ImageIcon(getClass().getResource("/img/thor.gif"));
        gif2.setIcon(thor);

        gif3 = new JLabel();
        gif3.setBounds(820, 90, 180, 170);
        this.add(gif3);
        ImageIcon strange = new ImageIcon(getClass().getResource("/img/doctor strange.gif"));
        gif3.setIcon(strange);

        gif4 = new JLabel();
        gif4.setBounds(730, 300, 278, 211);
        this.add(gif4);
        ImageIcon doom = new ImageIcon(getClass().getResource("/img/doctor doom.gif"));
        gif4.setIcon(doom);

        button1 = new ButtonAqua();
        button1.setLabel("IRON MAN");
        button1.setBackground(Color.red);
        button1.setBounds(160, 150, 120, 30);
        button1.addActionListener(this);
        this.add(button1);

        button2 = new ButtonAqua();
        button2.setLabel("THOR");
        button2.setBackground(Color.blue);
        button2.setBounds(290, 420, 120, 30);
        button2.addActionListener(this);
        this.add(button2);

        button3 = new ButtonAqua();
        button3.setLabel("DOCTOR STRANGE");
        button3.setBackground(Color.yellow);
        button3.setBounds(730, 150, 120, 30);
        button3.addActionListener(this);
        this.add(button3);

        button4 = new ButtonAqua();
        button4.setLabel("DOCTOR DOOM");
        button4.setBackground(Color.green);
        button4.setBounds(660, 420, 120, 30);
        button4.addActionListener(this);
        this.add(button4);
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imgFondo = new ImageIcon(getClass().getResource("/img/marvel.png"));
        g.drawImage(imgFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponents(g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        URL fondo=null;
        URL personaje=null;
        if (ae.getSource() == button1) {
            fondo = getClass().getResource("/img/fondo iron man.jpg");
            personaje = getClass().getResource("/img/iron man.gif");

        }

        if (ae.getSource() == button2) {
            fondo = getClass().getResource("/img/fondo thor.png");
            personaje = getClass().getResource("/img/thor.gif");

        }

        if (ae.getSource() == button3) {
             fondo = getClass().getResource("/img/fondo doctor strange.jpg");
            personaje = getClass().getResource("/img/doctor strange.gif");

        }

        if (ae.getSource() == button4) {
             fondo = getClass().getResource("/img/fondo doctor doom.jpg");
            personaje = getClass().getResource("/img/doctor doom.gif");

        }
        
            VentanaFrame iron = new VentanaFrame(personaje, fondo);
            SeleccionFrame selecc = new SeleccionFrame();
            selecc.setVisible(false);
            iron.setVisible(true);
    }
}
