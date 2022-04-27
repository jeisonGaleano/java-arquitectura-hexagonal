package com.ceiba.viajes.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.ServicioCrearUsuarioCarrion;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioCarrionTestDataBuilder;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;
import com.ceiba.viajes.servicio.testdatabuilder.ViajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearViajeTest {


    @Test
    @DisplayName("Deberia Crear el vehiculo de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        Viaje viaje = new ViajeTestDataBuilder().build();
        RepositorioViaje repositorioViaje = Mockito.mock(RepositorioViaje.class);
        Mockito.when(repositorioViaje.existeViaje(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioViaje.crear(viaje)).thenReturn(10L);
        ServicioCrearViaje servicioCrearVehiculo = new ServicioCrearViaje(repositorioViaje);
        Long viajeCarrion = servicioCrearVehiculo.ejecutar(viaje);
        assertEquals(10L,viajeCarrion);
        // act - assert
        Mockito.verify(repositorioViaje, Mockito.times(1)).crear(viaje);
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion el tipo de casa sea condominio y fin de semana")
    void deberiaLanzarUnaExepcionCuandoElServicioSeaFinDeSemanaParaCondominio() {
        // arrange
        ViajeTestDataBuilder viajeTestDataBuilder = new ViajeTestDataBuilder().conFechaServicioYTipoDeCasa(LocalDateTime.parse("2022-05-01T09:02:26.658"), "condominio");
        // act - assert
        BasePrueba.assertThrows(viajeTestDataBuilder::build, ExcepcionValorInvalido.class, "No se realizará servicio porque el lugar es condominio");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la fecha de servicio sea igual a la de creacion")
    void deberiaLanzarUnaExepcionCuandoElServicioSeaElMismoDia() {
        // arrange
        ViajeTestDataBuilder viajeTestDataBuilder = new ViajeTestDataBuilder().conFechaServicio(LocalDateTime.now());
        // act - assert
        BasePrueba.assertThrows(viajeTestDataBuilder::build, ExcepcionValorInvalido.class, "No se puede agendar servicio para el mismo día");
    }

    @Test
    @DisplayName("Deberia incrementar 5% en fines de semana")
    void deberiaIncrementarPorcentajeFinDeSemana() {
        // arrange
        ViajeTestDataBuilder viajeTestDataBuilder = new ViajeTestDataBuilder().conPorcentajeFinDeSemana(LocalDateTime.parse("2022-05-01T09:02:26.658"), 100000L);
        // act - assert
        BasePrueba.assertThrows(viajeTestDataBuilder::build, ExcepcionValorInvalido.class, "No se realizará servicio porque el lugar es condominio");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Viaje")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelViaje() {
        // arrange
        Viaje viaje = new ViajeTestDataBuilder().build();
        RepositorioViaje repositorioViaje = Mockito.mock(RepositorioViaje.class);
        Mockito.when(repositorioViaje.existeViaje(Mockito.anyLong(),Mockito.anyLong())).thenReturn(true);
        ServicioCrearViaje servicioCrearUsuario = new ServicioCrearViaje(repositorioViaje);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(viaje), ExcepcionDuplicidad.class,"El viaje ya existe en el sistema");
    }
}