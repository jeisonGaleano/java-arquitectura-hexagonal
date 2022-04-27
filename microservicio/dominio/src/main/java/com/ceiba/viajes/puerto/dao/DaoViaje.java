package com.ceiba.viajes.puerto.dao;


import com.ceiba.viajes.modelo.dto.DtoViaje;

import java.util.List;

public interface DaoViaje {

    List<DtoViaje> listarViajesActivosPorConductor(Long idConductor);

    List<DtoViaje> listarViajesPorConductor(Long idConductor);

    List<DtoViaje> listarPeticionesViajesPorCliente(Long idUsuario);

}
