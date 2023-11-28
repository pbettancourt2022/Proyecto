package panels;

import javax.swing.*;
import java.awt.*;

public class PanelAsientosSaloncama extends JPanel {
    public PanelAsientosSaloncama(){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        JLabel titulo = new JLabel("Asientos Salón-Cama", SwingConstants.CENTER);
        titulo.setBounds(100, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(130, 150, 150, 180);
        AsientosIzquierda.setLayout(new GridLayout(4, 2));
        for (int i =1; i<=11;i++){
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosIzquierda.add(a);
            if(((i%2==0)&&((i!=4))&&(i!=10))||(i==5)){
                i=i+1;
            }
        }
        JPanel AsientosDerecha = new JPanel();
        AsientosDerecha.setBounds(370, 150, 75, 180);
        AsientosDerecha.setLayout(new GridLayout(4, 1));
        for (int i =3; i<=12;i=i+3){
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha.add(a);
        }
        this.add(AsientosIzquierda);
        this.add(AsientosDerecha);
    }
    public void handleClick(int x, int y){
        repaint();
    }
}
