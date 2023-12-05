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
    private PanelAsientosSemicama AsientoSemicama;
    private PanelAsientosSaloncama AsientoSaloncama;
    /**
     * Integer que lleva cuenta de cual panel es el que se está mostrando
     */
    private int quePanel;
    public PanelPrincipal(){
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920,1080));

        quePanel = 1;

        inicio = new PanelInicio();
        inicio.setBounds(450,0, 600, 730);
        this.add(inicio);

        mov = new PanelMovimiento(this);
        mov.setBounds(0,730,1920,60);
        this.add(mov);

        hora = new PanelHora();
        hora.setBounds(500,50,500,1080);

        AsientoClasic = new PanelAsientosClasic();
        AsientoClasic.setBounds(150,0, 600, 790);

        AsientoSemicama = new PanelAsientosSemicama();
        AsientoSemicama.setBounds(150,0, 600, 790);

        AsientoSaloncama = new PanelAsientosSaloncama();
        AsientoSaloncama.setBounds(150,0, 600, 790);


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
    public void avanzarPanel(){
        System.out.println(quePanel);
        if(quePanel == 1){
            this.remove(inicio);
            this.add(hora);
            quePanel++;
        }
        else if(quePanel == 2){
            this.remove(hora);
            this.add(AsientoClasic);
            quePanel++;
        }
        else;
        revalidate();
        repaint();
    }
    public void retrocederPanel(){
        System.out.println(quePanel);
        if(quePanel == 3){
            this.remove(AsientoClasic);
            this.add(hora);
            quePanel--;
        }
        else if(quePanel == 2){
            this.remove(hora);
            this.add(inicio);
            quePanel--;
        } else;
        revalidate();
        repaint();
    }

    /** Metodo para manejar los clicks en todas las ventanas, manda las coordenadas del click a los otros paneles.
     *
     * @param x coordenada X del click.
     * @param y coordenada Y del click.
     */
    public void handleMouseClick(int x, int y){
        inicio.handleClick(x,y);
        mov.handleClick(x,y);
        hora.handleClick(x,y);
        AsientoClasic.handleClick(x,y);
        AsientoSaloncama.handleClick(x,y);
        AsientoSemicama.handleClick(x,y);
    }
}
