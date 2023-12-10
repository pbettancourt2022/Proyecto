package panels;

import org.example.Pasaje;
import org.example.PasajeSingleton;
import org.example.PasajesLista;
import org.example.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelPrincipal extends JPanel {
    private Pasaje pasaje;
    private PasajesLista pasajesLista;
    private PanelInicio inicio;
    private PanelMovimiento mov;
    private PanelHora hora;
    private PanelAsientosClasic AsientoClasic;
    private PanelAsientosSemicama AsientoSemicama;
    private PanelAsientosSaloncama AsientoSaloncama;
    private PanelDatos Datos;
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
        pasaje = PasajeSingleton.obtenerInstancia();
        pasajesLista = new PasajesLista();

        quePanel = 1;

        inicio = new PanelInicio(pasaje);
        inicio.setBounds(450,0, 600, 730);
        this.add(inicio);

        mov = new PanelMovimiento(this);
        mov.setBounds(0,730,1920,60);
        this.add(mov);

        hora = new PanelHora(pasaje);
        hora.setBounds(500,50,500,1080);

        AsientoClasic = new PanelAsientosClasic(pasaje);
        AsientoClasic.setBounds(100,0, 600, 790);

        AsientoSemicama = new PanelAsientosSemicama(pasaje);
        AsientoSemicama.setBounds(100,0, 600, 790);

        AsientoSaloncama = new PanelAsientosSaloncama(pasaje);
        AsientoSaloncama.setBounds(100,0, 600, 790);

        Datos = new PanelDatos(pasaje, this);
        Datos.setBounds(830,0, 600, 750);


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
        if(quePanel == 1){
            if(pasaje.getCiudadInicio() == null || pasaje.getCiudadDestino() == null || pasaje.getFecha() == null);
            else {
                this.remove(inicio);
                this.add(hora);
                quePanel++;
            }
        }
        else if(quePanel == 2){
            if(pasaje.getHora() == null || pasaje.getTipoAsiento() == null);
            else if(pasaje.getTipoAsiento().equals(TipoAsiento.CLASICO.getNombre())){
                this.remove(hora);
                this.add(AsientoClasic);
                this.add(Datos);
                quePanel++;
            }
            else if(pasaje.getTipoAsiento().equals(TipoAsiento.SEMICAMA.getNombre())){
                this.remove(hora);
                this.add(AsientoSemicama);
                this.add(Datos);
                quePanel++;
            }
            else if(pasaje.getTipoAsiento().equals(TipoAsiento.SALONCAMA.getNombre())){
                this.remove(hora);
                this.add(AsientoSaloncama);
                this.add(Datos);
                quePanel++;
            }
        }
        else;
        revalidate();
        repaint();
        System.out.println(pasaje.toString());
    }
    public void retrocederPanel(){
        System.out.println(quePanel);
        if(quePanel == 3){
            if(pasaje.getTipoAsiento().equals(TipoAsiento.CLASICO.getNombre())) {
                this.remove(AsientoClasic);
                this.remove(Datos);
                this.add(hora);
                quePanel--;
            }
            if(pasaje.getTipoAsiento().equals(TipoAsiento.SEMICAMA.getNombre())) {
                this.remove(AsientoSemicama);
                this.remove(Datos);
                this.add(hora);
                quePanel--;
            }
            if(pasaje.getTipoAsiento().equals(TipoAsiento.SALONCAMA.getNombre())) {
                this.remove(AsientoSaloncama);
                this.remove(Datos);
                this.add(hora);
                quePanel--;
            }
            pasaje.setTipoAsiento(null);
            pasaje.setHora(null);
        }
        else if(quePanel == 2){
            this.remove(hora);
            this.add(inicio);
            quePanel--;
            pasaje.setTipoAsiento(null);
            pasaje.setHora(null);
            pasaje.setFecha(null);
            pasaje.setCiudadDestino(null);
            pasaje.setCiudadInicio(null);
        } else;
        revalidate();
        repaint();
    }
    public void finalizarCompra(){
        pasajesLista.addPasaje(pasaje);
        // borra los datos de pasaje, como usamos singleton no podamos reinstanciar como antes
        pasaje.setCiudadInicio(null); pasaje.setCiudadDestino(null); pasaje.setFecha(null); pasaje.setHora(null);
        pasaje.setTipoAsiento(null); pasaje.setNumAsiento(0); pasaje.setPago(null);

        // se remueven los ultimos paneles abiertos
        this.remove(Datos); this.remove(AsientoSaloncama); this.remove(AsientoSemicama); this.remove(AsientoClasic);

        // crea de cero los paneles
        inicio = new PanelInicio(pasaje); inicio.setBounds(450,0, 600, 730);
        hora = new PanelHora(pasaje); hora.setBounds(500,50,500,1080);
        Datos = new PanelDatos(pasaje, this); Datos.setBounds(830,0, 600, 750);

        this.add(inicio);
        this.repaint();
        quePanel = 1;
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
        Datos.handleClick(x,y);
    }
}
