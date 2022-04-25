package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.ComandoUsuarioCarrion;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuarioCarrion;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuarioCarrion;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuarioCarrion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios-carrion")
@Api(tags = { "Controlador comando usuario-carrion"})
public class ComandoControladorUsuarioCarrion {

    private final ManejadorCrearUsuarioCarrion manejadorCrearUsuarioCarrion;

    private final ManejadorEliminarUsuarioCarrion manejadorEliminarUsuarioCarrion;

    private final ManejadorActualizarUsuarioCarrion manejadorActualizarUsuarioCarrion;


    public ComandoControladorUsuarioCarrion(ManejadorCrearUsuarioCarrion manejadorCrearUsuarioCarrion, ManejadorEliminarUsuarioCarrion manejadorEliminarUsuarioCarrion, ManejadorActualizarUsuarioCarrion manejadorActualizarUsuarioCarrion) {
        this.manejadorCrearUsuarioCarrion = manejadorCrearUsuarioCarrion;
        this.manejadorEliminarUsuarioCarrion = manejadorEliminarUsuarioCarrion;
        this.manejadorActualizarUsuarioCarrion = manejadorActualizarUsuarioCarrion;
    }

    @Autowired


    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuarioCarrion comandoUsuario) {
        return manejadorCrearUsuarioCarrion.ejecutar(comandoUsuario);
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarUsuarioCarrion.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoUsuarioCarrion comandoUsuario, @PathVariable Long id) {
        comandoUsuario.setId(id);
        manejadorActualizarUsuarioCarrion.ejecutar(comandoUsuario);
    }


}
