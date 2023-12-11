package org.example;

import java.util.ArrayList;

public class PasajesLista {
    private ArrayList<Pasaje> pasajes;

    public PasajesLista() {
        pasajes = new ArrayList<>();
    }

    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }

    public boolean pasajeYaComprado(Pasaje pasaje) {
        for (Pasaje pasajeExistente : pasajes) {
            if (pasajesIguales(pasaje, pasajeExistente)) {
                return true; // Si ya existe un pasaje con las mismas propiedades
            }
        }
        return false; // Si no se encuentra un pasaje con las mismas propiedades
    }

    // Función para comparar dos pasajes y verificar si son iguales en todas sus propiedades
    private boolean pasajesIguales(Pasaje pasajeA, Pasaje pasajeB) {
        return pasajeA.getCiudadInicio().equals(pasajeB.getCiudadInicio()) &&
                pasajeA.getCiudadDestino().equals(pasajeB.getCiudadDestino()) &&
                pasajeA.getFecha().equals(pasajeB.getFecha()) &&
                pasajeA.getHora().equals(pasajeB.getHora()) &&
                pasajeA.getTipoAsiento().equals(pasajeB.getTipoAsiento()) &&
                pasajeA.getNumAsiento() == pasajeB.getNumAsiento();
    }

    public void addPasaje(Pasaje a) {
        if (!pasajeYaComprado(a)) {
            pasajes.add(a);
        }
    }
}
