package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearUsuarioCarrionTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la longitud de la clave sea menor a 4")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
        // arrange
        UsuarioCarrionTestDataBuilder usuarioTestDataBuilder = new UsuarioCarrionTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        UsuarioCarrion usuario = new UsuarioCarrionTestDataBuilder().build();
        RepositorioUsuarioCarrion repositorioUsuario = Mockito.mock(RepositorioUsuarioCarrion.class);
        Mockito.when(repositorioUsuario.existePorIdentificacion(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(10L);
        ServicioCrearUsuarioCarrion servicioCrearUsuario = new ServicioCrearUsuarioCarrion(repositorioUsuario);
        Long idUsuario = servicioCrearUsuario.ejecutar(usuario);
        assertEquals(10L,idUsuario);
        // act - assert
        Mockito.verify(repositorioUsuario, Mockito.times(1)).crear(usuario);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        UsuarioCarrion usuario = new UsuarioCarrionTestDataBuilder().build();
        RepositorioUsuarioCarrion repositorioUsuario = Mockito.mock(RepositorioUsuarioCarrion.class);
        Mockito.when(repositorioUsuario.existePorIdentificacion(Mockito.anyLong())).thenReturn(true);
        ServicioCrearUsuarioCarrion servicioCrearUsuario = new ServicioCrearUsuarioCarrion(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

}