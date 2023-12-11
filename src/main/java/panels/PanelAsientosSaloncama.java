package panels;

import org.example.Pasaje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsientosSaloncama extends JPanel {
    /**
     * Instancia única de Pasaje, la utilizamos para acceder al pasaje y agregarle los datos obtenidos en el panel.
     */
    private Pasaje pasaje;

    /** Constructor de la clase, crea los botones de los asientos y guarda el numero de asiento
     * @param pasaje pasaje que rellenamos con los datos obtenidos en el panel
     */
    public PanelAsientosSaloncama(Pasaje pasaje){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        this.pasaje = pasaje;

        JLabel titulo = new JLabel("Asientos Salón-Cama", SwingConstants.CENTER);
        titulo.setBounds(120, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);
        JLabel titulo1 = new JLabel("Primer Piso", SwingConstants.CENTER);
        titulo1.setBounds(120, 80, 380, 30);
        titulo1.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(titulo1);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(130, 150, 150, 180);
        AsientosIzquierda.setLayout(new GridLayout(4, 2));
        for (int i =1; i<=11;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosIzquierda.add(a);
            if(((i%2==0)&&((i!=4))&&(i!=10))||(i==5)){
                i=i+1;
            }
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));

        }

        JPanel AsientosDerecha = new JPanel();
        AsientosDerecha.setBounds(370, 150, 75, 180);
        AsientosDerecha.setLayout(new GridLayout(4, 1));
        for (int i =3; i<=12;i=i+3){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha.add(a);
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));
        }
        this.add(AsientosIzquierda);
        this.add(AsientosDerecha);
    }
    /** Recibe el click desde PanelPrincipal y repinta el panel
     * @param x coordenada x del click
     * @param y coordenada y del click
     */
    public void handleClick(int x, int y){
        repaint();
    }
}
