package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class DtoTipoVehiculosCarrion {

    private Long id;
    @NotNull(message = "El nombre tipo vehiculo")
    private String nombreTipoVehiculo;
}
