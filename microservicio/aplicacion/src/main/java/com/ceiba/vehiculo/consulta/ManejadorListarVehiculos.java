package com.ceiba.vehiculo.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVehiculos {

    private final DaoVehiculo daoVehiculo;

    public ManejadorListarVehiculos(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public List<DtoVehiculoCarrion> ejecutar(Long idConductor){
        return this.daoVehiculo.listarVehiculoPorConductor(idConductor);
    }

}
