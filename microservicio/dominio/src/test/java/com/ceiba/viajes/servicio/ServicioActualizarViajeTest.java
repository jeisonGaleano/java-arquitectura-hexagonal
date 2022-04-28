package com.ceiba.viajes.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;
import com.ceiba.viajes.servicio.testdatabuilder.ViajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioActualizarViajeTest {

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaHacerActualizacionEnElRepositorio() {
        // arrange
        Viaje viaje = new ViajeTestDataBuilder().conId(1L).build();
        RepositorioViaje repositorioViaje = Mockito.mock(RepositorioViaje.class);
        Mockito.when(repositorioViaje.existeViaje(Mockito.anyLong(),Mockito.anyLong(), Mockito.anyBoolean())).thenReturn(true);
        ServicioActualizarViaje servicioActualizarViaje = new ServicioActualizarViaje(repositorioViaje);
        // act
        servicioActualizarViaje.ejecutar(viaje);
        //assert
        Mockito.verify(repositorioViaje,Mockito.times(1)).actualizar(viaje);
    }

    @Test
    @DisplayName("Debería validar existencia el viaje por id conductor y id usuari")
    void deberiaValidarExistenciaViaje(){
        Viaje viaje = new ViajeTestDataBuilder().conId(1L).build();
        RepositorioViaje repositorioViaje = Mockito.mock(RepositorioViaje.class);
        Mockito.when(repositorioViaje.existeViaje(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyBoolean())).thenReturn(false);
        ServicioActualizarViaje servicioActualizarViaje = new ServicioActualizarViaje(repositorioViaje);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarViaje.ejecutar(viaje), ExcepcionDuplicidad.class,"El no existe existe en el sistema");
    }
}