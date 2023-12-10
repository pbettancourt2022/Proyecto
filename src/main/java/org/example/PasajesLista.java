package org.example;

import java.util.ArrayList;

public class PasajesLista {
    private ArrayList<Pasaje> pasajes;
    public PasajesLista(){
        pasajes = new ArrayList<>();
    }
    public ArrayList<Pasaje> getPasajes(){return pasajes;}
    public void addPasaje(Pasaje a){pasajes.add(a);}

}