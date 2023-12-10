package panels;

import org.example.Pasaje;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

/**
 * Clase JPanel que representa el panel en el que se inicia el programa, da la opcion de escoger origen, destino y fecha del viaje.
 */
public class PanelInicio extends JPanel {
    /**
     * JComboBox utilizado para seleccionar la ciudad de origen
     */
    private JComboBox<String> origenComboBox;
    /**
     * JComboBox utilizado para seleccionar la ciudad de destino
     */
    private JComboBox<String> destinoComboBox;
    /**
     * JDateChooser utilizado para seleccionar la fecha del viaje
     */
    private JDateChooser fechaChooser;

    /**
     * Constructor de la clase, genera los ComboBoxes de origen y destino y también el JDateChooser de la fecha, además
     * guarda estos valores dentro del pasaje.
     * @param pasaje instancia de Pasaje que se rellena con las variables de este panel
     */
    public PanelInicio(Pasaje pasaje) {
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);

        JPanel Inicio = new JPanel();
        Inicio.setBounds(100, 130, 400, 300);
        Inicio.setLayout(null);

        // Rectángulo para desplegar los campos de texto - Origen
        JLabel rectanguloOrigen = new JLabel("Origen");
        rectanguloOrigen.setBounds(20, 20, 340, 25);
        rectanguloOrigen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(rectanguloOrigen);

        // ComboBox con ciudades disponibles - Origen
        String[] ciudadesOrigen = {"Seleccionar", "Concepción", "Talcahuano", "San Pedro", "Chillan", "Los Ángeles", "Santiago", "Temuco"};
        origenComboBox = new JComboBox<>(ciudadesOrigen);
        origenComboBox.setBounds(20, 50, 340, 25);
        add(origenComboBox);

        // Rectángulo para desplegar los campos de texto - Destino
        JLabel rectanguloDestino = new JLabel("Destino");
        rectanguloDestino.setBounds(20, 110, 340, 25);
        rectanguloDestino.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(rectanguloDestino);

        // ComboBox con ciudades disponibles - Destino
        String[] ciudadesDestino = {"Seleccionar", "Concepción", "Talcahuano", "San Pedro", "Chillan", "Los Ángeles", "Santiago", "Temuco"};
        destinoComboBox = new JComboBox<>(ciudadesDestino);
        destinoComboBox.setBounds(20, 140, 340, 25);
        add(destinoComboBox);

        // Rectángulo para desplegar los campos de texto - Destino
        JLabel rectanguloFecha = new JLabel("Fecha");
        rectanguloFecha.setBounds(20, 200, 340, 25);
        rectanguloFecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(rectanguloFecha);

        // Selector de fecha del viaje
        fechaChooser = new JDateChooser();
        fechaChooser.setBounds(20, 230, 200, 25);
        add(fechaChooser);

        Inicio.add(rectanguloOrigen);
        Inicio.add(origenComboBox);
        Inicio.add(rectanguloDestino);
        Inicio.add(destinoComboBox);
        Inicio.add(rectanguloFecha);
        Inicio.add(fechaChooser);
        this.add(Inicio);
        // Agregar ActionListener para el JComboBox de origen
        origenComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setCiudadInicio((String) origenComboBox.getSelectedItem());
            }
        });

        // Agregar ActionListener para el JComboBox de destino
        destinoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasaje.setCiudadDestino((String) destinoComboBox.getSelectedItem());
            }
        });

        // Agregar PropertyChangeListener para el JDateChooser
        fechaChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Obtener la fecha seleccionada del JDateChooser
                    pasaje.setFecha(fechaChooser.getDate());

                }
            }
        });
    }
    public JComboBox<String> getOrigenComboBox() {
        return origenComboBox;
    }

    public JComboBox<String> getDestinoComboBox() {
        return destinoComboBox;
    }

    public JDateChooser getFechaChooser() {
        return fechaChooser;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    /** Recibe el click desde PanelPrincipal y repinta el panel
     * @param x coordenada x del click
     * @param y coordenada y del click
     */
    public void handleClick(int x, int y){
        repaint();
    }
}
