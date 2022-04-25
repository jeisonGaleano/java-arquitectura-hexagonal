package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

    private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";


    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public Long ejecutar(VehiculoCarrion vehiculoCarrion) {
        validarExistenciaPrevia(vehiculoCarrion);
        return this.repositorioVehiculo.crear(vehiculoCarrion);
    }

    private void validarExistenciaPrevia(VehiculoCarrion vehiculoCarrion) {
        boolean existe = this.repositorioVehiculo.existePlaca(vehiculoCarrion.getPlaca());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
