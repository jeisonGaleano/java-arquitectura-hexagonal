package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.ServicioActualizarUsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioActualizarVehiculoTest {

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaHacerActualizacionEnElRepositorio() {
        // arrange
        VehiculoCarrion vehiculoCarrion = new VehiculoCarrionDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePlaca(Mockito.anyString())).thenReturn(true);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act
        servicioActualizarVehiculo.ejecutar(vehiculoCarrion);
        //assert
        Mockito.verify(repositorioVehiculo,Mockito.times(1)).actualizar(vehiculoCarrion);
    }

    @Test
    @DisplayName("Debería validar existencia de vehiculo por placa")
    void deberiaValidarExistenciaDeVehiculoPorPlaca(){
        VehiculoCarrion vehiculoCarrion = new VehiculoCarrionDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePlaca(Mockito.anyString())).thenReturn(false);
        ServicioActualizarVehiculo servicioActualizarUsuario = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(vehiculoCarrion), ExcepcionDuplicidad.class,"El vehiculo no existe en el sistema");
    }

}