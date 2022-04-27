package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarUsuarioCarrionTest {

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaHacerActualizacionEnElRepositorio() {
        // arrange
        UsuarioCarrion usuario = new UsuarioCarrionTestDataBuilder().conId(1L).build();
        RepositorioUsuarioCarrion repositorioUsuario = Mockito.mock(RepositorioUsuarioCarrion.class);
        Mockito.when(repositorioUsuario.existePorIdentificacion(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarUsuarioCarrion servicioActualizarUsuario = new ServicioActualizarUsuarioCarrion(repositorioUsuario);
        // act
        servicioActualizarUsuario.ejecutar(usuario);
        //assert
        Mockito.verify(repositorioUsuario,Mockito.times(1)).actualizar(usuario);
    }

    @Test
    @DisplayName("Debería validar existencia de usuario carrion")
    void deberiaValidarExistenciaDeUsuarioCarrion(){
        UsuarioCarrion usuarioCarrion = new UsuarioCarrionTestDataBuilder().conId(1L).build();
        RepositorioUsuarioCarrion repositorioUsuario = Mockito.mock(RepositorioUsuarioCarrion.class);
        Mockito.when(repositorioUsuario.existePorIdentificacion(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarUsuarioCarrion servicioActualizarUsuario = new ServicioActualizarUsuarioCarrion(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuarioCarrion), ExcepcionDuplicidad.class,"El no usuario existe en el sistema");
    }
}