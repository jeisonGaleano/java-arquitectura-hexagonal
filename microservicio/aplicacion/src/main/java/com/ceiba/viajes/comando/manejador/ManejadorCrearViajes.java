package com.ceiba.viajes.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.viajes.comando.ComandoViaje;
import com.ceiba.viajes.comando.fabrica.FabricaViaje;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.ServicioCrearViaje;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearViajes implements ManejadorComandoRespuesta<ComandoViaje, ComandoRespuesta<Long>> {


    private final FabricaViaje fabricaViaje;

    private final ServicioCrearViaje servicioCrearViaje;

    public ManejadorCrearViajes(FabricaViaje fabricaViaje, ServicioCrearViaje servicioCrearViaje) {
        this.fabricaViaje = fabricaViaje;
        this.servicioCrearViaje = servicioCrearViaje;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoViaje comando) {
        Viaje vehiculoCarrion = this.fabricaViaje.crearViaje(comando);
        return new ComandoRespuesta<>(this.servicioCrearViaje.ejecutar(vehiculoCarrion));
    }
}
