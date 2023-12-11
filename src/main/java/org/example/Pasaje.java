package org.example;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa el pasaje comprado con todos los datos fundamentales que este debe tener.
 */
public class Pasaje {
    /**
     * String que representa la ciudad del origen del viaje.
     */
    String ciudadInicio;
    /**
     * String que representa la ciudad a la que se desea ir en el viaje.
     */
    String ciudadDestino;
    /**
     * Variable tipo Date que representa la fecha escogida para el viaje.
     */
    Date fecha;
    /**
     * Variable tipo LocalTime que representa la hora escogida para el viaje.
     */
    LocalTime hora;
    /**
     * String que representa el tipo de asiento escogido por el comprador.
     */
    String tipoAsiento;
    /**
     * Integer que representa el asiento escogido por el comprador.
     */
    int numAsiento;
    /**
     * String que representa el nombre del comprador.
     */
    String nombre;
    /**
     * String que representa si el pago es Normal o Estudiante.
     */
    String pago;
    /**
     * Constructor de la clase, solamente inicializa las variables.
     */
    public Pasaje(){
    }
    public void setCiudadInicio(String ciudadInicio){this.ciudadInicio = ciudadInicio;}
    public String getCiudadInicio(){return ciudadInicio;}
    public void setCiudadDestino(String ciudadDestino){this.ciudadDestino = ciudadDestino;}
    public String getCiudadDestino(){return ciudadDestino;}
    public void setFecha(Date fecha){this.fecha = fecha;}
    public Date getFecha(){return fecha;}
    public void setHora(LocalTime hora){this.hora = hora;}
    public LocalTime getHora(){return hora;}
    public void setTipoAsiento(String tipoAsiento){this.tipoAsiento = tipoAsiento;}
    public String getTipoAsiento(){return tipoAsiento;}
    public void setNumAsiento(int numAsiento){this.numAsiento = numAsiento;}
    public int getNumAsiento(){return numAsiento;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setPago(String pago){this.pago = pago;}
    public String toString() {
        return "Pasaje{" +
                "ciudadInicio = '" + ciudadInicio + '\'' +
                ", ciudadDestino = '" + ciudadDestino + '\'' +
                ", fecha = " + fecha +
                ", hora = " + hora +
                ", tipoAsiento = '" + tipoAsiento + '\'' +
                ", numAsiento = " + numAsiento +
                ", nombre = '" + nombre + '\'' +
                ", pago = '" + pago + '\'' +
                '}';
    }

    /**
     * Método que revisa si dos pasajes son iguales
     * @param o un pasaje
     * @return retorna true si el pasaje es igual al que se le está comparando o si todos los elementos dentro del pasaje son iguales
     * retorna false si es que no son iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasaje pasaje = (Pasaje) o;
        return numAsiento == pasaje.numAsiento &&
                Objects.equals(ciudadInicio, pasaje.ciudadInicio) &&
                Objects.equals(ciudadDestino, pasaje.ciudadDestino) &&
                Objects.equals(fecha, pasaje.fecha) &&
                Objects.equals(hora, pasaje.hora) &&
                Objects.equals(tipoAsiento, pasaje.tipoAsiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudadInicio, ciudadDestino, fecha, hora, tipoAsiento, numAsiento);
    }
}