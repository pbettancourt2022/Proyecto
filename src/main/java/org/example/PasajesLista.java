package org.example;

import java.util.ArrayList;
/** Clase que guarda pasajes */
public class PasajesLista {
    /** Instancia de ArrayList, guarda pasajes */
    private ArrayList<Pasaje> pasajes;

    /** Constructor de la clase, inicializa pasajes */
    public PasajesLista() {
        pasajes = new ArrayList<>();
    }

    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }

    /** Método que revisa si un pasaje ya está comprado
     * @param pasaje el pasaje que se quiere comparar
     * @return retorna true si ya existe un pasaje con las mismas propiedades, false si no existe uno.
     */
    public boolean pasajeYaComprado(Pasaje pasaje) {
        for (Pasaje pasajeExistente : pasajes) {
            if (pasajesIguales(pasaje, pasajeExistente)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Método que revisa si dos pasajes son iguales
     * @param pasajeA pasaje uno a comparar
     * @param pasajeB pasaje dos a comparar
     * @return retorna true si todos los elementos dentro del pasaje son iguales
     */
    private boolean pasajesIguales(Pasaje pasajeA, Pasaje pasajeB) {
        return pasajeA.getCiudadInicio().equals(pasajeB.getCiudadInicio()) &&
                pasajeA.getCiudadDestino().equals(pasajeB.getCiudadDestino()) &&
                pasajeA.getFecha().equals(pasajeB.getFecha()) &&
                pasajeA.getHora().equals(pasajeB.getHora()) &&
                pasajeA.getTipoAsiento().equals(pasajeB.getTipoAsiento()) &&
                pasajeA.getNumAsiento() == pasajeB.getNumAsiento();
    }
    /** Método que agrega un pasaje a la lista */
    public void addPasaje(Pasaje a) {
        if (!pasajeYaComprado(a)) {
            pasajes.add(a);
        }
    }
}
