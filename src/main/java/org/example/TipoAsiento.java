package org.example;

/**
 * Enumeración de los tipos de asiento, contiene únicamente su nombre.
 */
public enum TipoAsiento {
    CLASICO("Clásico"), SEMICAMA("SemiCama"), SALONCAMA("Salón Cama");
    /**
     * Representa el nombre del tipo de asiento.
     */
    private String nombre;

    /**
     * Constructor de TipoAsiento
     * @param nombre representa a la variable nombre
     */
    TipoAsiento(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){return nombre;}
}
