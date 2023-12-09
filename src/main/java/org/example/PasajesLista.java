package org.example;

import java.util.ArrayList;

public class PasajesLista {
    private ArrayList<Pasaje> asientos;
    public PasajesLista(){
        asientos = new ArrayList<>();
    }
    public ArrayList<Pasaje> getAsientos(){return asientos;}
    public void addAsiento(Pasaje a){asientos.add(a);}

}