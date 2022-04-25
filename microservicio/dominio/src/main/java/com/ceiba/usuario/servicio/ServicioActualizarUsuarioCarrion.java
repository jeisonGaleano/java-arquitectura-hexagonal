package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;

public class ServicioActualizarUsuarioCarrion {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El no usuario existe en el sistema";

    private final RepositorioUsuarioCarrion repositorioUsuario;

    public ServicioActualizarUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(UsuarioCarrion usuario) {
        validarExistenciaPrevia(usuario);
        this.repositorioUsuario.actualizar(usuario);
    }

    private void validarExistenciaPrevia(UsuarioCarrion usuario) {
        boolean existe = this.repositorioUsuario.existePorIdentificacion(usuario.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
