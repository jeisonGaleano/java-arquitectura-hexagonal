package com.ceiba.viajes.modelo.dto;

import com.ceiba.viajes.servicio.testdatabuilder.ViajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DtoViajeTest {

    @Test
    @DisplayName("Deberia cargar correctamente el viaje")
    void deberiaCargarCorrectamenteElViaje() {
        // arrange
        //act
        DtoViaje dtoViaje = new ViajeTestDataBuilder().conId(1L).buildDto();
        //assert
        assertEquals(1, dtoViaje.getId());
        assertEquals(1, dtoViaje.getIdUsuario());
        assertEquals(2, dtoViaje.getIdConductor());
        assertEquals(10, dtoViaje.getToneladas());
        assertEquals(1, dtoViaje.getTipoVehiculo());
        assertEquals(LocalDateTime.parse("2022-05-01T09:02:26.658"), dtoViaje.getFechaCreacion());
        assertEquals(LocalDateTime.parse("2022-05-02T09:02:26.658"), dtoViaje.getFechaServicios());
        assertEquals("Barranquilla", dtoViaje.getOrigen());
        assertEquals("Santa Marta", dtoViaje.getDestino());
        assertEquals(true, dtoViaje.getTerminado());
        assertEquals("condominio", dtoViaje.getTipoCasa());
        assertEquals(100000L, dtoViaje.getPrecios());

    }

}