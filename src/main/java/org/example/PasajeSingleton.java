package org.example;

public class PasajeSingleton {
    private static Pasaje instanciaUnica;
    private String origen;
    private String destino;
    private String hora;
    private String tipoAsiento;
    private String nombre;
    private boolean esEstudiante;

    // Constructor privado para evitar instanciación externa
    private PasajeSingleton() {}

    // Método estático para obtener la instancia única del Singleton
    public static Pasaje obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Pasaje();
        }
        return instanciaUnica;
    }

    // Métodos para establecer y obtener las características del pasaje
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEsEstudiante(boolean esEstudiante) {
        this.esEstudiante = esEstudiante;
    }

    // Otros métodos para obtener la información del pasaje
    public String obtenerOrigen() {
        return origen;
    }

    public String obtenerDestino() {
        return destino;
    }

    public String obtenerHora() {
        return hora;
    }

    public String obtenerTipoAsiento() {
        return tipoAsiento;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public boolean esEstudiante() {
        return esEstudiante;
    }
}
//Asi se utiliza
/* Obtener la instancia única del pasaje
Pasaje pasaje = Pasaje.obtenerInstancia();

// Establecer características del pasaje
pasaje.setOrigen("Santiago");
pasaje.setDestino("Concepción");
pasaje.setHora("15:00");
pasaje.setTipoAsiento("Salón-Cama");
pasaje.setNombre("Juan Pérez");
pasaje.setEsEstudiante(true);

// Obtener información del pasaje
System.out.println("Origen: " + pasaje.obtenerOrigen());
System.out.println("Destino: " + pasaje.obtenerDestino());
System.out.println("Hora: " + pasaje.obtenerHora());
// Y así sucesivamente para las demás características */
