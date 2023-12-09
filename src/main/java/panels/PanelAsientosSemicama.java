package panels;

import org.example.Pasaje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsientosSemicama extends JPanel {
    private Pasaje pasaje;
    public PanelAsientosSemicama(Pasaje pasaje){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        this.pasaje = pasaje;

        JLabel titulo = new JLabel("Asientos Salón-Cama", SwingConstants.CENTER);
        titulo.setBounds(100, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(100, 150, 150, 450);
        AsientosIzquierda.setLayout(new GridLayout(10, 2));
        for (int i =13; i<=50;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosIzquierda.add(a);
            if((i%2==0)&&(i!=22)){
                i=i+2;
            }
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));

        }
        JPanel AsientosDerecha1 = new JPanel();
        AsientosDerecha1.setBounds(350, 150, 150, 90);
        AsientosDerecha1.setLayout(new GridLayout(2, 2));
        for (int i =15; i<=20;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha1.add(a);
            if(i%2==0){
                i=i+2;
            }
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));

        }
        JPanel AsientosDerecha2 = new JPanel();
        AsientosDerecha2.setBounds(350, 235, 150, 360);
        AsientosDerecha2.setLayout(new GridLayout(8, 2));
        for (int i =25; i<=50;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha2.add(a);
            if(i%2==0){
                i=i+2;
            }
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));

        }
        this.add(AsientosIzquierda);
        this.add(AsientosDerecha1);
        this.add(AsientosDerecha2);
    }
    public void handleClick(int x, int y){
        repaint();
    }
}
