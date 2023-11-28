package panels;

import javax.swing.*;
import java.awt.*;

public class PanelAsientosClasic extends JPanel {
    public PanelAsientosClasic(){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(50, 30, 400, 300);
        AsientosIzquierda.setLayout(new GridLayout(10, 2));
        for (int i =1; i<=20;i++){
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 380, 60);
            AsientosIzquierda.add(a);
        }
        this.add(AsientosIzquierda);
    }
    public void handleClick(int x, int y){
        repaint();
    }
}
