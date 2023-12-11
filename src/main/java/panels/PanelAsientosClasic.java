package panels;

import org.example.Pasaje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsientosClasic extends JPanel {
    /**
     * Instancia única de Pasaje, la utilizamos para acceder al pasaje y agregarle los datos obtenidos en el panel.
     */
    private Pasaje pasaje;

    /** Constructor de la clase, crea los botones de los asientos y guarda el numero de asiento
     * @param pasaje pasaje que rellenamos con los datos obtenidos en el panel
     */
    public PanelAsientosClasic(Pasaje pasaje){
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        this.pasaje = pasaje;


        JLabel titulo = new JLabel("Asientos Clasicos", SwingConstants.CENTER);
        titulo.setBounds(120, 50, 380, 30);

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);
        JLabel titulo1 = new JLabel("Primer Piso", SwingConstants.CENTER);
        titulo1.setBounds(120, 80, 380, 30);
        titulo1.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(titulo1);
        JPanel AsientosIzquierda = new JPanel();
        AsientosIzquierda.setBounds(100, 150, 150, 450);
        AsientosIzquierda.setLayout(new GridLayout(10, 2));
        for (int i =1; i<=40;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosIzquierda.add(a);
            if(i%2==0){
                i=i+2;

            }
            a.addActionListener(e -> pasaje.setNumAsiento(numAsiento));
        }
        JPanel AsientosDerecha = new JPanel();
        AsientosDerecha.setBounds(350, 150, 150, 450);
        AsientosDerecha.setLayout(new GridLayout(10, 2));
        for (int i =3; i<=40;i++){
            int numAsiento = i;
            JButton a = new JButton(String.valueOf(i));
            a.setBounds(0, 0, 80, 60);
            AsientosDerecha.add(a);
            if(i%2==0){
                i=i+2;
            }
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
