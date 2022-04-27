package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UsuarioCarrionTest {

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
    void deberiaFallarSinNombreDeUsuario() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    void deberiaFallarSinClave() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conClave(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la clave");
    }

    @Test
    void deberiaFallarSinTamanioClave() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conClave("123").conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conFechaCreacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }

    @Test
    void deberiaFallarSinIdentificacion() {

        //Arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conIdentificacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    usuarioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion de usuario");
    }
}
