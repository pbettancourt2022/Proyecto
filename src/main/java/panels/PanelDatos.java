package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDatos extends JPanel {
    private JTextField campoNombre;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;

    public PanelDatos() {
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);

        JLabel titulo = new JLabel("Datos Personales", SwingConstants.CENTER);
        titulo.setBounds(120, 50, 380, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setBounds(25, 125, 60, 20);
        this.add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(25, 152, 330, 20);
        this.add(campoNombre);

        JLabel tne = new JLabel("Pasaje estudiante", SwingConstants.CENTER);
        tne.setBounds(25, 160, 110, 120);
        tne.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(tne);

        // Crear los JRadioButton "Sí" y "No"
        siRadioButton = new JRadioButton("Sí");
        noRadioButton = new JRadioButton("No");

        // Establecer los límites y añadir los botones al panel
        siRadioButton.setBounds(140, 210, 50, 20);
        noRadioButton.setBounds(190, 210, 50, 20);
        this.add(siRadioButton);
        this.add(noRadioButton);

        // Agrupar los botones para asegurar que solo uno pueda ser seleccionado
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(siRadioButton);
        buttonGroup.add(noRadioButton);

        // Botón "Confirmar Datos"
        JButton confirmarDatosButton = new JButton("Confirmar Datos");
        confirmarDatosButton.setBounds(25, 260, 150, 30);
        confirmarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de nombre y la opción seleccionada
                String nombre = campoNombre.getText();
                String seleccionPasaje = (siRadioButton.isSelected()) ? "Sí" : "No";

                // Aquí puedes hacer lo que necesites con los datos recopilados
                // Por ejemplo, imprimirlos en la consola
                System.out.println("Nombre: " + nombre);
                System.out.println("Pasaje estudiante: " + seleccionPasaje);
            }
        });
        this.add(confirmarDatosButton);
    }

    public void handleClick(int x, int y) {
        repaint();
    }
}
