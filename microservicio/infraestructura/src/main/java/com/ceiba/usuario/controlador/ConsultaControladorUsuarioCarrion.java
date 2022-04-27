package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorListarUsuarioCarrion;
import com.ceiba.usuario.modelo.dto.DtoUsuarioCarrion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios-carrion")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuarioCarrion {

    private final ManejadorListarUsuarioCarrion manejadorListarUsuarioCarrion;

    public ConsultaControladorUsuarioCarrion(ManejadorListarUsuarioCarrion manejadorListarUsuarioCarrion) {
        this.manejadorListarUsuarioCarrion = manejadorListarUsuarioCarrion;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuarioCarrion> listar() {
        return this.manejadorListarUsuarioCarrion.ejecutar();
    }

}
