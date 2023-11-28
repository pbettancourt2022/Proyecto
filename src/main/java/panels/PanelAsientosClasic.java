package panels;

import javax.swing.*;
import java.awt.*;

public class PanelAsientosClasic extends JPanel {
    public PanelAsientosClasic(){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        JLabel titulo = new JLabel("Asientos Salón-Cama", SwingConstants.CENTER);
        titulo.setBounds(100, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(100, 150, 150, 450);
        AsientosIzquierda.setLayout(new GridLayout(10, 2));
        for (int i =1; i<=40;i++){
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosIzquierda.add(a);
            if(i%2==0){
                i=i+2;
            }
        }
        JPanel AsientosDerecha = new JPanel();
        AsientosDerecha.setBounds(350, 150, 150, 450);
        AsientosDerecha.setLayout(new GridLayout(10, 2));
        for (int i =3; i<=40;i++){
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha.add(a);
            if(i%2==0){
                i=i+2;
            }
        }
        this.add(AsientosIzquierda);
        this.add(AsientosDerecha);
    }
    public void handleClick(int x, int y){
        repaint();
    }
}
