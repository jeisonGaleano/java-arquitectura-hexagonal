package com.ceiba.viajes.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoViaje {

    private Long id;
    private Long idUsuario;
    private Long idConductor;
    private Long toneladas;
    private Long tipoVehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaServicio;
    private String origen;
    private String destino;
    private Boolean terminado;
    private String tipoCasa;
    private Long precio;
}
