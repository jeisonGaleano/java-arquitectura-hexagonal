package com.ceiba.viaje.controlador;

import com.ceiba.viajes.consulta.ManejadorListarViajes;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viajes")
@Api(tags={"Controlador consulta vehiculo"})
public class ConsultaControladorViaje {

    private final ManejadorListarViajes manejadorListarViajes;

    public ConsultaControladorViaje(ManejadorListarViajes manejadorListarViajes) {
        this.manejadorListarViajes = manejadorListarViajes;
    }

    @GetMapping(value="/viajes-activos/{idConductor}")
    @ApiOperation("Listar viajes activos por conductor")
    public List<DtoViaje> listarViajesActivosPorConductor(@PathVariable Long idConductor) {
        return this.manejadorListarViajes.ejecutarListarViajesActivosPorConductor(idConductor);
    }

    @GetMapping(value="/{idConductor}")
    @ApiOperation("Listar viajes por conductor")
    public List<DtoViaje> listarViajesPorConductor(@PathVariable Long idConductor) {
        return this.manejadorListarViajes.ejecutarListarViajesPorConductor(idConductor);
    }

    @GetMapping(value="/{idCliente}")
    @ApiOperation("Listar peticiones de viajes de cliente")
    public List<DtoViaje> listarPeticionesViajesPorCliente (@PathVariable Long idCliente) {
        return this.manejadorListarViajes.ejecutarListarPeticionesViajesPorCliente(idCliente);
    }
}
