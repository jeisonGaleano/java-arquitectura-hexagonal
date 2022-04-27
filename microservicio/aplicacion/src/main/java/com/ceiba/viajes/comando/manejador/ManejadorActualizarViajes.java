package com.ceiba.viajes.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.viajes.comando.ComandoViaje;
import com.ceiba.viajes.comando.fabrica.FabricaViaje;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.ServicioActualizarViaje;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarViajes implements ManejadorComando<ComandoViaje> {


    private final FabricaViaje fabricaVehiculo;

    private final ServicioActualizarViaje servicioActualizarViaje;

    public ManejadorActualizarViajes(FabricaViaje fabricaVehiculo, ServicioActualizarViaje servicioActualizarViaje) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioActualizarViaje = servicioActualizarViaje;
    }

    @Override
    public void ejecutar(ComandoViaje comando) {
        Viaje viaje = this.fabricaVehiculo.crearViaje(comando);
        this.servicioActualizarViaje.ejecutar(viaje);
    }
}
