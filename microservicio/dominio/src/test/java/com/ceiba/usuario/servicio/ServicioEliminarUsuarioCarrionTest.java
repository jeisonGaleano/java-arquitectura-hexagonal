package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioEliminarUsuarioCarrionTest {

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioUsuarioCarrion repositorioUsuario = Mockito.mock(RepositorioUsuarioCarrion.class);
        ServicioEliminarUsuarioCarrion servicioEliminarUsuario = new ServicioEliminarUsuarioCarrion(repositorioUsuario);

        servicioEliminarUsuario.ejecutar(1l);

        Mockito.verify(repositorioUsuario, Mockito.times(1)).eliminar(1l);

    }

}