package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.ServicioCrearUsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearVehiculoTest {


    @Test
    @DisplayName("Deberia Crear el vehiculo de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        VehiculoCarrion vehiculo = new VehiculoCarrionDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePlaca(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioVehiculo.crear(vehiculo)).thenReturn(10L);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        Long vehiculoCarrion = servicioCrearVehiculo.ejecutar(vehiculo);
        assertEquals(10L,vehiculoCarrion);
        // act - assert
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).crear(vehiculo);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la placa")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaPlaca() {
        // arrange
        VehiculoCarrion vehiculoCarrion = new VehiculoCarrionDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePlaca(Mockito.anyString())).thenReturn(true);
        ServicioCrearVehiculo servicioCrearUsuario = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(vehiculoCarrion), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la longitud de la placa sea menor a 6")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
        // arrange
        VehiculoCarrionDataBuilder vehiculoCarrionDataBuilder = new VehiculoCarrionDataBuilder().conPlaca("124");
        // act - assert
        BasePrueba.assertThrows(vehiculoCarrionDataBuilder::build, ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }
}