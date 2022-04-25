package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class TipoVehiculoCarrion {
    private Long id;
    private String nombreTipoVehiculo;

    public TipoVehiculoCarrion(Long id, String nombreTipoVehiculo) {
        this.id = id;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }
}
