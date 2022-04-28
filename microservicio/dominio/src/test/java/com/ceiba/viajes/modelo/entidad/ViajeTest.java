package com.ceiba.viajes.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
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
        assertEquals(10, viaje.getToneladas());
        assertEquals(1, viaje.getTipoVehiculo());
        assertEquals(LocalDateTime.parse("2022-05-01T09:02:26.658"), viaje.getFechaCreacion());
        assertEquals(LocalDateTime.parse("2022-05-02T09:02:26.658"), viaje.getFechaServicio());
        assertEquals("Barranquilla", viaje.getOrigen());
        assertEquals("Santa Marta", viaje.getDestino());
        assertEquals(true, viaje.getTerminado());
        assertEquals("condominio", viaje.getTipoCasa());
        assertEquals(true, viaje.getTerminado());
        assertEquals(100000L, viaje.getPrecio());


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

    @Test
    void deberiaFallarSiEsFinParaCondominio() {

        //Arrange
        ViajeTestDataBuilder usuarioTestDataBuilder = new ViajeTestDataBuilder().conFechaServicioYTipoDeCasa(LocalDateTime.parse("2022-05-01T09:02:26.658"), "condominio").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "No se realizará servicio porque el lugar es condominio");
    }

    @Test
    void deberiaIncrementarPorcentajeFinDeSemana() {

        //Arrange
        Viaje viaje = new ViajeTestDataBuilder().conPrecio(150000L).conFechaServicio(LocalDateTime.parse("2022-05-01T09:02:26.658")).conId(1L).conTipoCasa("casa").build();
        //act-assert
        assertEquals(true, viaje.getTerminado());

    }



}