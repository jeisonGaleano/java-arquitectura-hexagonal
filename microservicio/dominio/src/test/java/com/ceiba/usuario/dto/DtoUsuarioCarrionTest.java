package com.ceiba.usuario.dto;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DtoUsuarioCarrionTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        UsuarioCarrion usuario = new UsuarioCarrionTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(1, usuario.getId());
        assertEquals("Jeison", usuario.getNombre());
        assertEquals("Galeano", usuario.getApellido());
        assertEquals("Json", usuario.getUsuario());
        assertEquals("1234", usuario.getClave());
        assertEquals(fechaCreacion, usuario.getFechaCreacion());
        assertEquals(22, usuario.getEdad());
        assertEquals("jeison.galeano@gmail.com", usuario.getCorreoElectronico());
        assertEquals(1, usuario.getTipoRol());
        assertEquals(123456789, usuario.getIdentificacion());
    }

    @Test
    void deberiaFallarSinUsuario() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.buildDto();
                },
                Exception.class, "El usuario es obligatorio");
    }
}