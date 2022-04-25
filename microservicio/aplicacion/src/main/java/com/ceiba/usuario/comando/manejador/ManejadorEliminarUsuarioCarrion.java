package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuarioCarrion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarUsuarioCarrion implements ManejadorComando<Long> {

    private final ServicioEliminarUsuarioCarrion servicioEliminarUsuarioCarrion;

    public ManejadorEliminarUsuarioCarrion(ServicioEliminarUsuarioCarrion servicioEliminarUsuarioCarrion) {
        this.servicioEliminarUsuarioCarrion = servicioEliminarUsuarioCarrion;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarUsuarioCarrion.ejecutar(id);

    }
}
