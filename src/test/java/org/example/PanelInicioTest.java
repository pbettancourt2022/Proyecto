package org.example;

import org.example.Pasaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import panels.PanelInicio;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PanelInicioTest {

    private PanelInicio panelInicio;
    private Pasaje pasajeMock;

    @BeforeEach
    public void setUp() {
        pasajeMock = Mockito.mock(Pasaje.class);
        panelInicio = new PanelInicio(pasajeMock);
    }

    @Test
    public void testPasajeSetters() {
        JComboBox<String> origenComboBox = panelInicio.getOrigenComboBox();
        JComboBox<String> destinoComboBox = panelInicio.getDestinoComboBox();

        // Simular selección de origen y destino
        origenComboBox.setSelectedItem("Concepción");
        destinoComboBox.setSelectedItem("Santiago");

        // Verificar que los métodos correspondientes de Pasaje se llamen con los valores correctos
        Mockito.verify(pasajeMock).setCiudadInicio("Concepción");
        Mockito.verify(pasajeMock).setCiudadDestino("Santiago");
    }
    @Test
    public void testFechaChooser() {
        // Simular selección de una fecha en fechaChooser
        JDateChooser fechaChooser = panelInicio.getFechaChooser();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 10); // Definir la fecha que se desea simular
        fechaChooser.setDate(calendar.getTime());

        // Verificar que el método correspondiente en Pasaje se llame con la fecha seleccionada
        Mockito.verify(pasajeMock).setFecha(calendar.getTime());
    }

    // Puedes agregar más pruebas para verificar el comportamiento esperado con fechaChooser y otras interacciones
}
