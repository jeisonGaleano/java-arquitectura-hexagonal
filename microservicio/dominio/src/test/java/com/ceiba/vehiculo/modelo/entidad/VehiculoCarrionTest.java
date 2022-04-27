package com.ceiba.vehiculo.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoCarrionTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        //act
        VehiculoCarrion vehiculoCarrion = new VehiculoCarrionDataBuilder().conPlaca("QHM980").conId(1L).build();
        //assert
        assertEquals(1, vehiculoCarrion.getId());
        assertEquals(1, vehiculoCarrion.getTipoVehiculo());
        assertEquals("Nissan", vehiculoCarrion.getMarca());
        assertEquals("6726HAJSK", vehiculoCarrion.getNumeroChasis());
        assertEquals("12HSTY56", vehiculoCarrion.getNumeroMotor());
        assertEquals(1, vehiculoCarrion.getIdConductor());
        assertEquals(1, vehiculoCarrion.getToneladas());
        assertEquals(2024, vehiculoCarrion.getModelo());
    }

    @Test
    void deberiaFallarSinNumeroDeMotor() {

        //Arrange
        VehiculoCarrionDataBuilder vehiculoCarrionDataBuilder = new VehiculoCarrionDataBuilder().conNumeroMotor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoCarrionDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar numero de motor");
    }

    @Test
    void deberiaFallarSinTamanioPlaca() {

        //Arrange
        VehiculoCarrionDataBuilder usuarioTestDataBuilder = new VehiculoCarrionDataBuilder().conPlaca("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }

    @Test
    void deberiaFallarSinNumeroMotor() {

        //Arrange
        VehiculoCarrionDataBuilder usuarioTestDataBuilder = new VehiculoCarrionDataBuilder().conNumeroMotor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar numero de motor");
    }

    @Test
    void deberiaFallarSinNumeroChasis() {

        //Arrange
        VehiculoCarrionDataBuilder usuarioTestDataBuilder = new VehiculoCarrionDataBuilder().conNumeroChasis(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar numero chasis");
    }

}