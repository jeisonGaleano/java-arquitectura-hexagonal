package com.ceiba.viajes.modelo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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

    public DtoViaje(Long id, Long idUsuario, Long idConductor, Long tonelads,
                    Long tipoVehiculo, LocalDateTime fechaCreacion, LocalDateTime
                            fechaServicio, String origen, String destino, Boolean terminado, String tipoCasa, Long precio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idConductor = idConductor;
        this.tonelads = tonelads;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaCreacion = fechaCreacion;
        this.fechaServicio = fechaServicio;
        this.origen = origen;
        this.destino = destino;
        this.terminado = terminado;
        this.tipoCasa = tipoCasa;
        this.precio = precio;
    }
}
