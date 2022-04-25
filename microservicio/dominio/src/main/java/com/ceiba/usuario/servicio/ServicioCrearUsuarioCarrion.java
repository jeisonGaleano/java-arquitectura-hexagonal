package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
public class ServicioCrearUsuarioCarrion {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuarioCarrion repositorioUsuarioCarrion;


    public ServicioCrearUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuarioCarrion) {
        this.repositorioUsuarioCarrion = repositorioUsuarioCarrion;
    }

    public Long ejecutar(UsuarioCarrion usuario) {
        validarExistenciaPrevia(usuario);
        return this.repositorioUsuarioCarrion.crear(usuario);
    }

    private void validarExistenciaPrevia(UsuarioCarrion usuario) {
        boolean existe = this.repositorioUsuarioCarrion.existePorIdentificacion(usuario.getIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
