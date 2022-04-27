package com.ceiba.vehiculo.controlador;

import com.ceiba.vehiculo.consulta.ManejadorListarVehiculos;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@Api(tags={"Controlador consulta vehiculo"})
public class ConsultaControladorVehiculo {

    private final ManejadorListarVehiculos manejadorListarVehiculos;

    public ConsultaControladorVehiculo(ManejadorListarVehiculos manejadorListarVehiculos) {
        this.manejadorListarVehiculos = manejadorListarVehiculos;
    }

    @GetMapping(value="/{idConductor}")
    @ApiOperation("Listar Vehiculos Por Conductor")
    public List<DtoVehiculoCarrion> listarVehiculosConductor(@PathVariable Long idConductor) {
        return this.manejadorListarVehiculos.ejecutar(idConductor);
    }
}
