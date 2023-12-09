package org.example;

import java.time.LocalTime;
import java.util.Date;

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
}