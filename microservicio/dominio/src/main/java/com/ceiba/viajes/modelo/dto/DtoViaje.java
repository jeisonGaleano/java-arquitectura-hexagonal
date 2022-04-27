package com.ceiba.viajes.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoViaje {

    private Long id;
    private Long idUsuario;
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
