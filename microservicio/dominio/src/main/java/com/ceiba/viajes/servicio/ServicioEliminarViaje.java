package com.ceiba.viajes.servicio;

import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;

public class ServicioEliminarViaje {

    private final RepositorioViaje repositorioViaje;

    public ServicioEliminarViaje(RepositorioViaje repositorioViaje) {
        this.repositorioViaje = repositorioViaje;
    }

    public void ejecutar(Long id) {
        this.repositorioViaje.eliminar(id);
    }

}
