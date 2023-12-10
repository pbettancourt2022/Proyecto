package org.example;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Pasaje {
    String ciudadInicio;
    String ciudadDestino;
    Date fecha;
    LocalTime hora;
    String tipoAsiento;
    int numAsiento;
    String nombre;
    String pago;
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