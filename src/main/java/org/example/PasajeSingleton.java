package org.example;

public class PasajeSingleton {
    private static Pasaje instanciaUnica;

    // Constructor privado para evitar instanciación externa
    private PasajeSingleton() {}

    // Método estático para obtener la instancia única del Singleton
    public static Pasaje obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Pasaje();
        }
        return instanciaUnica;
    }
}

