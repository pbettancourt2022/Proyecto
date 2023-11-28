package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMovimiento extends JPanel {
    /**
     * Ocupamos esta instancia para conectar el panel principal con este
     */
    private PanelPrincipal panelPrincipal;
    public PanelMovimiento(PanelPrincipal panelPrincipal){
        super();
        setLayout(null);
        this.panelPrincipal = panelPrincipal;

        // Crear botones
        JButton b1 = new JButton(("Retroceder"));
        b1.setBounds(10, 10, 120, 40);
        b1.setPreferredSize(new Dimension(120, 40));

        JButton b2 = new JButton("Siguiente");
        b2.setBounds(1400, 10, 120, 40);
        b2.setPreferredSize(new Dimension(120, 40));

        // Manejar botones
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.retrocederPanel();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.avanzarPanel();
            }
        });

        this.add(b1);
        this.add(b2);
    }


    public void handleClick(int x, int y){
        repaint();
    }
}
