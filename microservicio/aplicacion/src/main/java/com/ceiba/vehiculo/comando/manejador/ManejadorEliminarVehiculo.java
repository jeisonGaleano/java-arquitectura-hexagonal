package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vehiculo.comando.fabrica.FabricaVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarVehiculo implements ManejadorComando<Long> {


    private final FabricaVehiculo fabricaVehiculo;

    private final ServicioEliminarVehiculo servicioEliminarVehiculo;

    public ManejadorEliminarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioEliminarVehiculo servicioEliminarVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioEliminarVehiculo = servicioEliminarVehiculo;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarVehiculo.ejecutar(id);
    }
}
