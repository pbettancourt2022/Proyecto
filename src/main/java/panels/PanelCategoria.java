package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCategoria extends JPanel {
    public PanelCategoria(){
        super();
        setBounds(920,40,380,530);
        this.setLayout(null);

        // Crear botones
        JPanel botones = new JPanel();
        botones.setBounds(200, 200, 200, 300);
        botones.setLayout(new GridLayout(3,1));
        JButton btnCama = new JButton("Cama");
        btnCama.setBounds(0, 0, 100, 60);
        JButton btnSemiCama = new JButton("Semi-Cama");
        btnSemiCama.setBounds(0, 0, 100, 60);
        JButton btnCamaPremium = new JButton("Cama Premium");
        btnCamaPremium.setBounds(0, 0, 100, 60);

        btnCama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSemiCama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCamaPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        botones.add(btnCama);
        botones.add(btnSemiCama);
        botones.add(btnCamaPremium);
        this.add(botones);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));

        // Dibuja el texto en el panel
        String texto = "Seleccione la categoría de asiento";
        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(texto)) / 2; // Centrar horizontalmente
        int y = (metrics.getAscent()+50); // Centrar verticalmente
        g.drawString(texto, x, y);

    }
}
