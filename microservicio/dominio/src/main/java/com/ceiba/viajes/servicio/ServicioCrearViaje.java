package com.ceiba.viajes.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;

public class ServicioCrearViaje {

    private static final String EL_VIAJE_YA_EXISTE_EN_EL_SISTEMA = "El viaje ya existe en el sistema";

    private final RepositorioViaje repositorioViaje;

    public ServicioCrearViaje(RepositorioViaje repositorioViaje) {
        this.repositorioViaje = repositorioViaje;
    }

    public Long ejecutar(Viaje viaje) {
        validarExistenciaPrevia(viaje);
        return this.repositorioViaje.crear(viaje);
    }
    private void validarExistenciaPrevia(Viaje viaje) {
        boolean existe = this.repositorioViaje.existeViaje(viaje.getIdConductor(), viaje.getIdUsuario());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_VIAJE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
