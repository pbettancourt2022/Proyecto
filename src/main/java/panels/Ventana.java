package panels;
import javax.swing.ImageIcon;
import javax.swing.*;
public class Ventana extends JFrame {
    /** Constructor de Ventana, simplemente crea la ventana e implementa el panel principal, además agrega un ícono */
    public Ventana(){
        super("Compra de pasajes");
        setLayout(null);

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());
    }
}
