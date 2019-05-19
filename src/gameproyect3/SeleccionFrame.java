package gameproyect3;

import javax.swing.JFrame;

/**
 *
 * @author James Alzate Jr
 */
public class SeleccionFrame extends JFrame{
    SeleccionPanel seleccionP = new SeleccionPanel();
    
    public SeleccionFrame(){
        super("Game");
        this.setSize(1058, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(seleccionP);
    }
}
