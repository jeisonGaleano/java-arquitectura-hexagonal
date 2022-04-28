package com.ceiba.vehiculo.servicio;

import com.ceiba.usuario.comando.ComandoUsuarioCarrion;
import com.ceiba.vehiculo.comando.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {

    private Long id;
    private Long idConductor;
    private String placa;
    private String numeroMotor;
    private String numeroChasis;
    private Long toneladas;
    private Long tipoVehiculo;
    private Long modelo;
    private String marca;

    public ComandoVehiculoTestDataBuilder() {
        id=1L;
        idConductor=1L;
        placa="QHM970";
        numeroMotor="NHSAHH112";
        numeroChasis="HGQHU111";
        toneladas=10L;
        tipoVehiculo=1L;
        modelo=2020L;
        marca="Nissan";
    }

    public ComandoVehiculo build(){
        return new ComandoVehiculo(id,idConductor,placa,numeroMotor,numeroChasis,
                toneladas,tipoVehiculo,modelo,marca);
    }
}
