package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;

public interface RepositorioVehiculo {

    Long crear(VehiculoCarrion usuario);

    void actualizar(VehiculoCarrion usuario);

    void eliminar(Long id);

    boolean existePlaca(String placa);

}
