package org.example;

public enum TipoAsiento {
    CLASICO("Clásico"), SEMICAMA("SemiCama"), SALONCAMA("Salón Cama");
    private String nombre;
    TipoAsiento(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){return nombre;}
}
