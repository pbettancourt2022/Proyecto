package panels;
import org.example.Pasaje;
import org.example.PasajesLista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDatos extends JPanel {
    /**
     * Instancia única de Pasaje, la utilizamos para acceder al pasaje y agregarle los datos obtenidos en el panel.
     */
    private Pasaje pasaje;
    /** Instancia de PanelPrincipal, la ocupamos para acceder al método para realizar el pago dentro de esa clase. */
    private PanelPrincipal panelPrincipal;
    /** Instancia de JTextField, la ocupamos para obtener el nombre del comprador. */
    private JTextField campoNombre;
    /** Instancia de JRadioButton, su uso es marcar si el pago es estudiante. */
    private JRadioButton siRadioButton;
    /** Análogamente, esta instancia la ocupamos para marcar si el pago es normal. */
    private JRadioButton noRadioButton;
    /** Instacia de JTextArea, despliega todos los datos del pasaje. */
    private JTextArea areaDatosCompra;
    /** Instancia de PasajesLista, la ocupamos para acceder a la lista de pasajes comprados */
    private PasajesLista pasajesLista;
    /**
     * Constructor de la clase, agrega los datos del comprador al pasaje y realiza la compra.
     * @param pasaje pasaje que se rellena con los datos
     * @param panelPrincipal para poder usar el método de finalizar compra
     * @param pasajesLista para acceder a la lista de pasajes comprados
     */
    public PanelDatos(Pasaje pasaje, PanelPrincipal panelPrincipal, PasajesLista pasajesLista) {
        super();
        setBounds(920, 40, 380, 530);
        this.setLayout(null);
        this.pasaje = pasaje;
        this.panelPrincipal = panelPrincipal;
        this.pasajesLista = pasajesLista;

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


        JButton comprar = new JButton("Comprar");
        comprar.addActionListener(e -> {panelPrincipal.finalizarCompra();});
        comprar.setBounds(25, 700, 150, 30);

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
                if(pasaje.getNumAsiento() == 0 || nombre == null || seleccionPasaje == null ){
                    datosCompra = new StringBuilder();
                    datosCompra.append("Debe completar los datos.");
                } else if (pasajesLista.pasajeYaComprado(pasaje)) {
                    pasaje.setNumAsiento(0);
                    datosCompra = new StringBuilder();
                    datosCompra.append("El pasaje ya ha sido comprado. No está disponible.").append("\n");
                    JOptionPane.showMessageDialog(null, "El pasaje ya ha sido comprado. No está disponible.", "Pasaje no disponible", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    datosCompra = new StringBuilder();
                    datosCompra.append("Origen: ").append(pasaje.getCiudadInicio()).append("\n");
                    datosCompra.append("Destino: ").append(pasaje.getCiudadDestino()).append("\n");
                    datosCompra.append("Fecha: ").append(pasaje.getFecha()).append("\n");
                    datosCompra.append("Hora: ").append(pasaje.getHora()).append("\n");
                    datosCompra.append("Tipo de asiento: ").append(pasaje.getTipoAsiento()).append("\n");
                    datosCompra.append("Número de asiento: ").append(String.valueOf(pasaje.getNumAsiento())).append("\n");
                    datosCompra.append("Nombre: ").append(nombre).append("\n");
                    datosCompra.append("Pasaje estudiante: ").append(seleccionPasaje).append("\n");

                    PanelDatos.this.add(comprar);
                    PanelDatos.this.repaint();

                }
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
    /** Recibe el click desde PanelPrincipal y repinta el panel
     * @param x coordenada x del click
     * @param y coordenada y del click
     */
    public void handleClick(int x, int y) {
        repaint();
    }
}
