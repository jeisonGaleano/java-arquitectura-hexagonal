package com.ceiba.vehiculo.modelo.dto;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoVehiculoCarrionTest {

    @Test
    @DisplayName("Deberia cargar correctamente el vehiculo")
    void deberiaCargarCorrectamenteElVehiculo() {
        // arrange
        //act
        DtoVehiculoCarrion vehiculoCarrion = new VehiculoCarrionDataBuilder().conPlaca("QHM980").conId(1L).buildDto();
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
}