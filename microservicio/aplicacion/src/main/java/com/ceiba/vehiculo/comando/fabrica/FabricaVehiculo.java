package com.ceiba.vehiculo.comando.fabrica;

import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {

    public VehiculoCarrion crearVehiculo(ComandoVehiculo comandoVehiculo){
        return new VehiculoCarrion(comandoVehiculo.getId(),comandoVehiculo.getIdConductor(), comandoVehiculo.getPlaca(),
                comandoVehiculo.getNumeroMotor(), comandoVehiculo.getNumeroChasis(), comandoVehiculo.getToneladas(),
                comandoVehiculo.getTipoVehiculo(), comandoVehiculo.getModelo(), comandoVehiculo.getMarca());
    }
}
