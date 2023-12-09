package panels;
import org.example.Pasaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDatos extends JPanel {
    Pasaje pasaje;
    private JTextField campoNombre;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JTextArea areaDatosCompra;

    public PanelDatos(Pasaje pasaje) {
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        this.pasaje = pasaje;

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
        confirmarDatosButton.setBounds(25, 320, 150, 30);
        confirmarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener todos los datos ingresados en los campos
                String nombre = campoNombre.getText();
                String seleccionPasaje = (siRadioButton.isSelected()) ? "Sí" : "No";
                if(siRadioButton.isSelected()) seleccionPasaje = "Sí";
                if(noRadioButton.isSelected()) seleccionPasaje = "No";
                // agregar datos al pasaje
                pasaje.setNombre(nombre);
                if (seleccionPasaje.equals("Sí")) pasaje.setPago("Estudiante");
                else pasaje.setPago("Normal");

                // Construir el texto con la información recopilada
                StringBuilder datosCompra = new StringBuilder();
                datosCompra.append("Origen: ").append(pasaje.getCiudadInicio()).append("\n");
                datosCompra.append("Destino: ").append(pasaje.getCiudadDestino()).append("\n");
                datosCompra.append("Fecha: ").append(pasaje.getFecha()).append("\n");
                datosCompra.append("Hora: ").append(pasaje.getHora()).append("\n");
                datosCompra.append("Tipo de asiento: ").append(pasaje.getTipoAsiento()).append("\n");
                datosCompra.append("Número de asiento: ").append(String.valueOf(pasaje.getNumAsiento())).append("\n");
                datosCompra.append("Nombre: ").append(nombre).append("\n");
                datosCompra.append("Pasaje estudiante: ").append(seleccionPasaje).append("\n");

                // Mostrar los datos en el JTextArea
                areaDatosCompra.setText(datosCompra.toString());
            }
        });
        this.add(confirmarDatosButton);

        // JTextArea para mostrar los datos de la compra
        areaDatosCompra = new JTextArea();
        areaDatosCompra.setEditable(false);
        areaDatosCompra.setBounds(25, 370, 330, 150);
        this.add(areaDatosCompra);
    }

    public void handleClick(int x, int y) {
        repaint();
    }
}
