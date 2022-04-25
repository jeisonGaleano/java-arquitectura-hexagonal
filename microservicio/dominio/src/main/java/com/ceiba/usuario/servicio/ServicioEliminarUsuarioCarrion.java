package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;

public class ServicioEliminarUsuarioCarrion {

    private final RepositorioUsuarioCarrion repositorioUsuarioCarrion;

    public ServicioEliminarUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuarioCarrion) {
        this.repositorioUsuarioCarrion = repositorioUsuarioCarrion;
    }

    public void ejecutar(Long id) {
        this.repositorioUsuarioCarrion.eliminar(id);
    }

}
