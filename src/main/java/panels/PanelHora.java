package panels;

import org.example.Pasaje;
import org.example.TipoAsiento;
import org.example.PasajesLista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalTime;

/**
 * Clase JPanel que representa la muestra de las horas dentro del programa.
 */
public class PanelHora extends JPanel {
    /**
     * Instancia única de Pasaje, la utilizamos para acceder al pasaje y agregarle los datos obtenidos en el panel.
     */
    Pasaje pasaje;
    /**
     * Constructor de la clase, crea los JLabels con los datos de los buses y sus horas, y también crea los JRadioButtons
     * para seleccionar una hora y tipo de asiento.
     * @param pasaje pasaje que rellenamos con los datos obtenidos en el panel
     */
    public PanelHora(Pasaje pasaje){
        super();
        setLayout(null);
        this.pasaje = pasaje;

        // botones de compra
        JPanel botones = new JPanel(new GridLayout(13,1));
        ButtonGroup gBotones = new ButtonGroup();

        JRadioButton b1 = new JRadioButton();
        JRadioButton b2 = new JRadioButton();
        JRadioButton b3 = new JRadioButton();
        JRadioButton b4 = new JRadioButton();
        JRadioButton b5 = new JRadioButton();
        JRadioButton b6 = new JRadioButton();
        JRadioButton b7 = new JRadioButton();
        JRadioButton b8 = new JRadioButton();
        JRadioButton b9 = new JRadioButton();
        JRadioButton b10 = new JRadioButton();
        JRadioButton b11 = new JRadioButton();
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.CLASICO.getNombre());
                pasaje.setHora(LocalTime.of(7,0));
        }});
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SEMICAMA.getNombre());
                pasaje.setHora(LocalTime.of(8,0));
        }});
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SALONCAMA.getNombre());
                pasaje.setHora(LocalTime.of(8,0));
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.CLASICO.getNombre());
                pasaje.setHora(LocalTime.of(10,0));
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SEMICAMA.getNombre());
                pasaje.setHora(LocalTime.of(12,0));
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SALONCAMA.getNombre());
                pasaje.setHora(LocalTime.of(12,0));            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.CLASICO.getNombre());
                pasaje.setHora(LocalTime.of(15,0));
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.CLASICO.getNombre());
                pasaje.setHora(LocalTime.of(17,0));
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SEMICAMA.getNombre());
                pasaje.setHora(LocalTime.of(18,0));
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.SALONCAMA.getNombre());
                pasaje.setHora(LocalTime.of(18,0));
            }
        });
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setTipoAsiento(TipoAsiento.CLASICO.getNombre());
                pasaje.setHora(LocalTime.of(20,0));
            }
        });

        // añadir botones
        botones.add(b1); botones.add(b2); botones.add(b3); botones.add(b4); botones.add(b5); botones.add(b6);
        botones.add(b7); botones.add(b8); botones.add(b9); botones.add(b10); botones.add(b11);

        gBotones.add(b1); gBotones.add(b2); gBotones.add(b3); gBotones.add(b4); gBotones.add(b5); gBotones.add(b6);
        gBotones.add(b7); gBotones.add(b8); gBotones.add(b9); gBotones.add(b10); gBotones.add(b11);

        botones.setBounds(400,0,100,650);
        this.add(botones);

        // información
        JPanel labels = new JPanel((new GridLayout(13,1)));


        JLabel i1 = new JLabel("Hora: 07:00; tipo de asiento: " + TipoAsiento.CLASICO.getNombre() + '.');
        JLabel i2 = new JLabel("Hora: 08:00; tipo de asiento: " + TipoAsiento.SEMICAMA.getNombre() + '.');
        JLabel i3 = new JLabel("Hora: 08:00; tipo de asiento: " + TipoAsiento.SALONCAMA.getNombre() + '.');
        JLabel i4 = new JLabel("Hora: 10:00; tipo de asiento: " + TipoAsiento.CLASICO.getNombre() + '.');
        JLabel i5 = new JLabel("Hora: 12:00; tipo de asiento: " + TipoAsiento.SEMICAMA.getNombre() + '.');
        JLabel i6 = new JLabel("Hora: 12:00; tipo de asiento: " + TipoAsiento.SALONCAMA.getNombre() + '.');
        JLabel i7 = new JLabel("Hora: 15:00; tipo de asiento: " + TipoAsiento.CLASICO.getNombre() + '.');
        JLabel i8 = new JLabel("Hora: 17:00; tipo de asiento: " + TipoAsiento.CLASICO.getNombre() + '.');
        JLabel i9 = new JLabel("Hora: 18:00; tipo de asiento: " + TipoAsiento.SEMICAMA.getNombre() + '.');
        JLabel i10 = new JLabel("Hora: 18:00; tipo de asiento: " + TipoAsiento.SEMICAMA.getNombre() + '.');
        JLabel i11 = new JLabel("Hora: 20:00; tipo de asiento: " + TipoAsiento.CLASICO.getNombre() + '.');

        labels.add(i1);
        labels.add(i2);
        labels.add(i3);
        labels.add(i4);
        labels.add(i5);
        labels.add(i6);
        labels.add(i7);
        labels.add(i8);
        labels.add(i9);
        labels.add(i10);
        labels.add(i11);

        labels.setBounds(0,0,300,650);
        this.add(labels);

    }
    /** Recibe el click desde PanelPrincipal y repinta el panel
     * @param x coordenada x del click
     * @param y coordenada y del click
     */
    public void handleClick(int x, int y){
        repaint();
    }
}
