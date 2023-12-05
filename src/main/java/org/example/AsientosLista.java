package org.example;

import java.util.ArrayList;

public class AsientosLista {
    private ArrayList<Asiento> asientos;
    public AsientosLista(){
        asientos = new ArrayList<>();
    }
    public ArrayList<Asiento> getAsientos(){return asientos;}
    public void addAsiento(Asiento a){asientos.add(a);}

}