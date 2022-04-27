package com.ceiba.usuario.modelo.dto;

import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import com.ceiba.viajes.servicio.testdatabuilder.ViajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DtoUsuarioCarrionTest {


    @Test
    @DisplayName("Deberia cargar correctamente el viaje")
    void deberiaCargarCorrectamenteElViaje() {
        // arrange
        //act
        DtoUsuarioCarrion dtoUsuarioCarrion = new UsuarioCarrionTestDataBuilder().conId(1L).buildDto();
        //assert
        assertEquals(1, dtoUsuarioCarrion.getId());
        assertEquals("Jeison", dtoUsuarioCarrion.getNombre());
        assertEquals("Galeano", dtoUsuarioCarrion.getApellido());
        assertEquals("Json", dtoUsuarioCarrion.getUsuario());
        assertEquals("1234", dtoUsuarioCarrion.getClave());
        assertEquals(22, dtoUsuarioCarrion.getEdad());
        assertEquals("jeison.galeano@gmail.com", dtoUsuarioCarrion.getCorreoElectronico());
        assertEquals(1, dtoUsuarioCarrion.getTipoRol());
        assertEquals(123456789, dtoUsuarioCarrion.getIdentificacion());
    }
}