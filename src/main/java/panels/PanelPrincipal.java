package panels;

import org.example.Pasaje;
import org.example.PasajeSingleton;
import org.example.PasajesLista;
import org.example.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase principal del proyecto, contiene el resto de los paneles y maneja el movimiento de estos con ayuda de
 * PanelMovimiento, además maneja los clicks y los envía al resto de paneles.
 */
public class PanelPrincipal extends JPanel {
    /** Instancia de Pasaje, es el que se rellena de datos a lo largo del programa para despues guardarse y ser reiniciado. */
    private Pasaje pasaje;
    /** Instancia de PasajesLista, guarda los pasajes después de realizar la compra. */
    private PasajesLista pasajesLista;
    /** Instacia de PanelInicio, la usamos para obtener las ciudades y la fecha del viaje. */
    private PanelInicio inicio;
    /** Instancia de PanelMovimiento, la usamos para mover los paneles. */
    private PanelMovimiento mov;
    /** Instancia de PanelHora, la usamos para escoger la hora y el tipo de asiento del viaje. */
    private PanelHora hora;
    /** Los tres Paneles de asientos funcionan básicamente igual, uno obtiene el numero de asiento de ellos. */
    private PanelAsientosClasic AsientoClasic;
    private PanelAsientosSemicama AsientoSemicama;
    private PanelAsientosSaloncama AsientoSaloncama;
    /** Instancia de PanelDatos, la usamos para obtener el nombre y tipo de pago del comprador, además con ella se paga. */
    private PanelDatos Datos;
    /**
     * Integer que lleva cuenta de cual panel es el que se está mostrando
     */
    private int quePanel;
    /** Constructor de PanelPrincipal, maneja las acciones del proyecto. */
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

        Datos = new PanelDatos(pasaje, this, pasajesLista);
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
    /** Método que maneja el botón para avanzar de panel en PanelMovimiento */
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
    }
    /** Método que maneja el botón para retroceder de panel en PanelMovimiento */
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
    /** Método que maneja la finalización de la compra en PanelDatos, agrega el pasaje a la lista de pasajes, reinicia
     * el pasaje, y reinicia los paneles que tienen datos guardados, además vuelve al panel inicial*/
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
        Datos = new PanelDatos(pasaje, this, pasajesLista); Datos.setBounds(830,0, 600, 750);

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
