package com.ceiba.viajes;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;

public class ServicioActualizarViaje {

    private static final String EL_VIAJE_NO_EXISTE_EN_EL_SISTEMA = "El no existe existe en el sistema";

    private final RepositorioViaje repositorioViaje;

    public ServicioActualizarViaje(RepositorioViaje repositorioViaje) {
        this.repositorioViaje = repositorioViaje;
    }

    public void ejecutar(Viaje viaje) {
        validarExistenciaPrevia(viaje);
        this.repositorioViaje.actualizar(viaje);
    }

    private void validarExistenciaPrevia(Viaje viaje) {
        boolean existe = this.repositorioViaje.existeViaje(viaje.getIdConductor(), viaje.getIdUsuario());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_VIAJE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
