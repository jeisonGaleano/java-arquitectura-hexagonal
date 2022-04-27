package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {

    private static final String EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA = "El vehiculo no existe en el sistema";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(VehiculoCarrion vehiculoCarrion) {
        validarExistenciaPrevia(vehiculoCarrion);
        this.repositorioVehiculo.actualizar(vehiculoCarrion);
    }

    private void validarExistenciaPrevia(VehiculoCarrion vehiculoCarrion) {
        boolean existe = this.repositorioVehiculo.existePlaca(vehiculoCarrion.getPlaca());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
