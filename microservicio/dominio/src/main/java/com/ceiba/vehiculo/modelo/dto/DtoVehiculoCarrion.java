package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class DtoVehiculoCarrion {

    private Long id;
    @NotNull(message = "El ID conductor es obligatorio")
    private Long idConductor;
    @NotNull(message = "La placa es obligatorio")
    private String placa;
    @NotNull(message = "El No de motor es obligatorio")
    private String numeroMotor;
    @NotNull(message = "El No de chasis es obligatorio")
    private String numeroChasis;
    @NotNull(message = "Las toneladas son obligatorio")
    private Long toneladas;

    @NotNull(message = "El tipo de vehiculo es obligatorio")
    private Long tipoVehiculo;
    private Long modelo;
    private String marca;
}
