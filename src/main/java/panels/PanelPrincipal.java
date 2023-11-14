package panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelPrincipal extends JPanel {
    private PanelCategoria categorias;
    public PanelPrincipal(){
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));

        categorias=new PanelCategoria();
        categorias.setBounds(450,0, 600, 790);
        this.add(categorias);

        // Agrega el MouseListener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                handleMouseClick(x, y);
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    /** Metodo para manejar los clicks en todas las ventanas, manda las coordenadas del click a los otros paneles.
     *
     * @param x coordenada X del click.
     * @param y coordenada Y del click.
     */
    public void handleMouseClick(int x, int y){
        //expendedor.handleClick(x, y);
        //comprador.handleClick(x, y);
    }
}
