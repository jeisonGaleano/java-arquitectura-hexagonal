package com.ceiba.viajes.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import com.ceiba.viajes.puerto.dao.DaoViaje;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarViajes {

    private final DaoViaje daoViaje;

    public ManejadorListarViajes(DaoViaje daoViaje) {
        this.daoViaje = daoViaje;
    }

    public List<DtoViaje> ejecutarListarViajesPorConductor(Long idConductor){
        return this.daoViaje.listarViajesPorConductor(idConductor);
    }

    public List<DtoViaje> ejecutarListarPeticionesViajesPorCliente(Long idUsuario){

        return this.daoViaje.listarPeticionesViajesPorCliente(idUsuario);
    }

    public List<DtoViaje> ejecutarListarViajesActivosPorConductor(Long idConductor){
        return this.daoViaje.listarViajesActivosPorConductor(idConductor);
    }


}
