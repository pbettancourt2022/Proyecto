package panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelPrincipal extends JPanel {
    private PanelCategoria categorias;
    private PanelInicio inicio;
    private PanelMovimiento mov;
    private PanelHora hora;
    private PanelAsientosClasic AsientoClasic;
    public PanelPrincipal(){
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));

//        inicio = new PanelInicio();
//        inicio.setBounds(450,0, 600, 730);
//        this.add(inicio);

        mov = new PanelMovimiento(this);
        mov.setBounds(0,730,1920,60);
        this.add(mov);

        hora = new PanelHora();
        hora.setBounds(500,50,500,1080);
        this.add(hora);

//        AsientoClasic=new PanelAsientosClasic();
//        AsientoClasic.setBounds(450,0, 600, 790);
//        this.add(AsientoClasic);
        // categorias=new PanelCategoria();
        //categorias.setBounds(450,0, 600, 790);
        //this.add(categorias);

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
    public void cambiarPanel(){
        int quePanel = 1;
        if(quePanel == 1);
    }

    /** Metodo para manejar los clicks en todas las ventanas, manda las coordenadas del click a los otros paneles.
     *
     * @param x coordenada X del click.
     * @param y coordenada Y del click.
     */
    public void handleMouseClick(int x, int y){

    }
}
