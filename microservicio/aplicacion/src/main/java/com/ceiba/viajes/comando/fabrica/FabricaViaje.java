package com.ceiba.viajes.comando.fabrica;

import com.ceiba.viajes.comando.ComandoViaje;
import com.ceiba.viajes.modelo.entidad.Viaje;
import org.springframework.stereotype.Component;

@Component
public class FabricaViaje {

    public Viaje crearViaje (ComandoViaje comandoViaje){
        return new Viaje(comandoViaje.getId(),comandoViaje.getIdUsuario(),comandoViaje.getIdConductor(),comandoViaje.getTonelads(),comandoViaje.getTipoVehiculo(),comandoViaje.getFechaCreacion()
        ,comandoViaje.getFechaServicio(),comandoViaje.getOrigen(),comandoViaje.getDestino(),comandoViaje.getTerminado(), comandoViaje.getTipoCasa(), comandoViaje.getPrecio());
    }
}
