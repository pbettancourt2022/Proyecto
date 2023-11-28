package panels;

import org.example.TipoAsiento;
import javax.swing.*;
import java.awt.*;

public class PanelHora extends JPanel {
    public PanelHora(){
        super();
        setLayout(null);

        // botones de compra
        JPanel botones = new JPanel(new GridLayout(13,1));
        for (int i = 1; i < 14; i++){
            JButton b = new JButton(String.valueOf(i));
            b.setPreferredSize(new Dimension(100,50));
            botones.add(b);
        }
        botones.setBounds(400,0,100,650);
        this.add(botones);

        // información
        JPanel labels = new JPanel((new GridLayout(13,1)));
        for (int i = 0; i < 13; i++){
            JLabel info = new JLabel("Hora: " + (i + 8) + ":00, tipo de asiento: " + TipoAsiento.CLASICO.getNombre());
            info.setPreferredSize(new Dimension(300, 100 + 50 * i));
            labels.add(info);
        }
        labels.setBounds(0,0,300,650);
        this.add(labels);

    }
    public void handleClick(int x, int y){
        repaint();
    }
}