package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDatos extends JPanel {
    public PanelDatos() {
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);

        JLabel titulo = new JLabel("Datos Personales", SwingConstants.CENTER);
        titulo.setBounds(120, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setBounds(25, 75, 60, 20);
        this.add(etiquetaNombre);

        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(25, 102, 330, 20);
        this.add(campoNombre);

        JLabel tne = new JLabel("Pasaje estudiante", SwingConstants.CENTER);
        tne.setBounds(25, 152, 110, 120);
        tne.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(tne);

        // Crear los JRadioButton "Sí" y "No"
        JRadioButton siRadioButton = new JRadioButton("Sí");
        JRadioButton noRadioButton = new JRadioButton("No");

        // Establecer los límites y añadir los botones al panel
        siRadioButton.setBounds(140, 170, 50, 20);
        noRadioButton.setBounds(190, 170, 50, 20);
        this.add(siRadioButton);
        this.add(noRadioButton);

        // Agrupar los botones para asegurar que solo uno pueda ser seleccionado
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(siRadioButton);
        buttonGroup.add(noRadioButton);
    }

    public void handleClick(int x, int y) {
        repaint();
    }
}
