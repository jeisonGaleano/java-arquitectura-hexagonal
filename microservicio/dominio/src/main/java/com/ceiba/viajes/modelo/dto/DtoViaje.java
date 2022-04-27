package com.ceiba.viajes.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoViaje {

    private Long id;
    @NotNull(message = "El ID Usuario es obligatorio")
    private Long idUsuario;
    @NotNull(message = "El ID Conductor es obligatorio")
    private Long idConductor;
    private Long tonelads;
    private Long tipoVehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaServicio;
    private String origen;
    private String destino;
    private Boolean terminado;
    private String tipoCasa;
    private Long precio;


}
