package com.ceiba.viajes.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.servicio.testdatabuilder.ViajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViajeTest {


    @Test
    @DisplayName("Deberia crear correctamente el viaje")
    void deberiaCrearCorrectamenteElViaje() {

        LocalDateTime localDateTime = LocalDateTime.now();
        // arrange
        //act
        Viaje viaje = new ViajeTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, viaje.getId());
        assertEquals(1, viaje.getIdUsuario());
        assertEquals(2, viaje.getIdConductor());
        assertEquals(10, viaje.getTonelads());
        assertEquals(1, viaje.getTipoVehiculo());
        assertEquals(LocalDateTime.parse("2022-05-01T09:02:26.658"), viaje.getFechaCreacion());
        assertEquals("Barranquilla", viaje.getOrigen());
        assertEquals("Santa Marta", viaje.getDestino());
        assertEquals(true, viaje.getTerminado());
        assertEquals("condominio", viaje.getTipoCasa());
        assertEquals(true, viaje.getTerminado());
    }

    @Test
    void deberiaFallarSinIdUsuario() {

        //Arrange
        ViajeTestDataBuilder usuarioTestDataBuilder = new ViajeTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id usuario");
    }

    @Test
    void deberiaFallarSinIdConductor() {

        //Arrange
        ViajeTestDataBuilder usuarioTestDataBuilder = new ViajeTestDataBuilder().conIdConductor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id conductor");
    }

}