package com.ceiba.viajes.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.viajes.comando.fabrica.FabricaViaje;
import com.ceiba.viajes.ServicioEliminarViaje;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarViajes implements ManejadorComando<Long> {


    private final FabricaViaje fabricaViaje;

    private final ServicioEliminarViaje servicioEliminarViaje;

    public ManejadorEliminarViajes(FabricaViaje fabricaViaje, ServicioEliminarViaje servicioEliminarViaje) {
        this.fabricaViaje = fabricaViaje;
        this.servicioEliminarViaje = servicioEliminarViaje;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarViaje.ejecutar(id);
    }
}
