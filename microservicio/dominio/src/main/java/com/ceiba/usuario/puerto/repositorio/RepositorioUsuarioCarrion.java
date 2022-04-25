package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;

public interface RepositorioUsuarioCarrion {

    Long crear(UsuarioCarrion usuario);

    void actualizar(UsuarioCarrion usuario);

    void eliminar(Long id);

    boolean existePorIdentificacion(Long identificacion);

}
