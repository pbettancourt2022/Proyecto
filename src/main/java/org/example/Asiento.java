package org.example;

import java.time.LocalTime;
import java.util.Date;

public class Asiento {
    String tipoAsiento;
    Date fecha;
    LocalTime hora;
    int numAsiento;
    public Asiento(String tipoAsiento, Date fecha, LocalTime hora){
        this.tipoAsiento = tipoAsiento;
        this.fecha = fecha;
        this.hora = hora;
        numAsiento = 0;
    }
    public void setNumAsiento(int numAsiento){this.numAsiento = numAsiento;}

}