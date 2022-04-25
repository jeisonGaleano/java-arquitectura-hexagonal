package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoUsuarioCarrion;
import com.ceiba.usuario.comando.fabrica.FabricaUsuarioCarrion;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.servicio.ServicioActualizarUsuarioCarrion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarUsuarioCarrion implements ManejadorComando<ComandoUsuarioCarrion> {

    private final FabricaUsuarioCarrion fabricaUsuario;
    private final ServicioActualizarUsuarioCarrion servicioActualizarUsuario;

    public ManejadorActualizarUsuarioCarrion(FabricaUsuarioCarrion fabricaUsuario, ServicioActualizarUsuarioCarrion servicioActualizarUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioActualizarUsuario = servicioActualizarUsuario;
    }

    @Override
    public void ejecutar(ComandoUsuarioCarrion comando) {
        UsuarioCarrion usuario = this.fabricaUsuario.crearUsuario(comando);
        this.servicioActualizarUsuario.ejecutar(usuario);
    }
}
