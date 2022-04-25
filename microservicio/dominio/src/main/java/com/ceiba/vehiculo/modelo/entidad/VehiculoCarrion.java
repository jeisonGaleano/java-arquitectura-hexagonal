package com.ceiba.vehiculo.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoCarrion {

    private Long id;
    private Long idConductor;
    private String placa;
    private String numeroMotor;
    private String numeroChasis;
    private Long toneladas;
    private Long tipoVehiculo;
    private Long modelo;
    private String marca;

}
