package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuarioCarrion;
import com.ceiba.usuario.comando.fabrica.FabricaUsuarioCarrion;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.usuario.servicio.ServicioCrearUsuarioCarrion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuarioCarrion implements ManejadorComandoRespuesta<ComandoUsuarioCarrion, ComandoRespuesta<Long>> {

    private final FabricaUsuarioCarrion fabricaUsuario;

    private final ServicioCrearUsuarioCarrion servicioCrearUsuarioCarrion;

    public ManejadorCrearUsuarioCarrion(FabricaUsuarioCarrion fabricaUsuario, ServicioCrearUsuarioCarrion servicioCrearUsuarioCarrion) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuarioCarrion = servicioCrearUsuarioCarrion;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoUsuarioCarrion comando) {
        UsuarioCarrion usuario = this.fabricaUsuario.crearUsuario(comando);
        return new ComandoRespuesta<>(this.servicioCrearUsuarioCarrion.ejecutar(usuario));
    }
}
