package com.ceiba.viaje.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.viajes.comando.ComandoViaje;
import com.ceiba.viajes.comando.manejador.ManejadorActualizarViajes;
import com.ceiba.viajes.comando.manejador.ManejadorCrearViajes;
import com.ceiba.viajes.comando.manejador.ManejadorEliminarViajes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viaje")
@Api(tags = { "Controlador comando vehiculos"})
public class ComandoControladorViaje {

    private final ManejadorCrearViajes manejadorCrearViajes;
    private final ManejadorActualizarViajes manejadorActualizarViajes;
    private final ManejadorEliminarViajes manejadorEliminarViajes;

    @Autowired

    public ComandoControladorViaje(ManejadorCrearViajes manejadorCrearViajes, ManejadorActualizarViajes manejadorActualizarViajes,
                                   ManejadorEliminarViajes manejadorEliminarViajes) {
        this.manejadorCrearViajes = manejadorCrearViajes;
        this.manejadorActualizarViajes = manejadorActualizarViajes;
        this.manejadorEliminarViajes = manejadorEliminarViajes;
    }

    @PostMapping
    @ApiOperation("Crear viaje")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoViaje comandoViaje) {
        return manejadorCrearViajes.ejecutar(comandoViaje);
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar viaje")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarViajes.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar viaje")
    public void actualizar(@RequestBody ComandoViaje comandoViaje, @PathVariable Long id) {
        comandoViaje.setId(id);
        manejadorActualizarViajes.ejecutar(comandoViaje);
    }
}
