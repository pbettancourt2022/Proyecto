package panels;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(250, 450, 120, 40);
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.add(btnSiguiente);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
