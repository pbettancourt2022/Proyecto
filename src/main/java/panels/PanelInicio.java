package panels;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class PanelInicio extends JPanel {
    private JComboBox<String> origenComboBox;
    private JComboBox<String> destinoComboBox;
    private JDateChooser fechaChooser;

    public PanelInicio() {
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
                String origenSeleccionado = (String) origenComboBox.getSelectedItem();
                // Aquí puedes guardar la selección del origen en alguna variable o estructura de datos
                // Ejemplo: guardarOrigen(origenSeleccionado);
            }
        });

        // Agregar ActionListener para el JComboBox de destino
        destinoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destinoSeleccionado = (String) destinoComboBox.getSelectedItem();
                // Aquí puedes guardar la selección del destino en alguna variable o estructura de datos
                // Ejemplo: guardarDestino(destinoSeleccionado);
            }
        });

        // Agregar PropertyChangeListener para el JDateChooser
        fechaChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    // Obtener la fecha seleccionada del JDateChooser
                    Date fechaSeleccionada = fechaChooser.getDate();
                    // Aquí puedes guardar la fecha seleccionada en alguna variable o estructura de datos
                    // Ejemplo: guardarFecha(fechaSeleccionada);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    public void handleClick(int x, int y){
        repaint();
    }
}
