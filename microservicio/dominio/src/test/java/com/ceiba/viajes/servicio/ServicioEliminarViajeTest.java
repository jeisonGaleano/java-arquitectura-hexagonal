package com.ceiba.viajes.servicio;

import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioEliminarViajeTest {
    @Test
    @DisplayName("Deberia eliminar el vehiculo llamando al repositorio")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioViaje repositorioViaje= Mockito.mock(RepositorioViaje.class);
        ServicioEliminarViaje servicioEliminarViaje = new ServicioEliminarViaje(repositorioViaje);

        servicioEliminarViaje.ejecutar(1l);

        Mockito.verify(repositorioViaje, Mockito.times(1)).eliminar(1l);

    }

}