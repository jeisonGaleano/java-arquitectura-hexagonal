package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoUsuarioCarrion;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuarioCarrion {

    public UsuarioCarrion crearUsuario (ComandoUsuarioCarrion comandoCarrion){
        return new UsuarioCarrion(comandoCarrion.getId(), comandoCarrion.getIdentificacion(), comandoCarrion.getNombre(),
                comandoCarrion.getApellido(),comandoCarrion.getUsuario(),comandoCarrion.getClave(),comandoCarrion.getEdad(),comandoCarrion.getTipoRol(),
                comandoCarrion.getCiudadResidencia(),comandoCarrion.getCorreoElectronico(),comandoCarrion.getFechaCreacion());
     }
}
