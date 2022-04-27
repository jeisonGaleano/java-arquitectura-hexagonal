package com.ceiba.vehiculo.puerto.dao;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;

import java.util.List;

public interface DaoVehiculo {

    List<DtoVehiculoCarrion> listarVehiculoPorConductor(Long idConductor);

}
