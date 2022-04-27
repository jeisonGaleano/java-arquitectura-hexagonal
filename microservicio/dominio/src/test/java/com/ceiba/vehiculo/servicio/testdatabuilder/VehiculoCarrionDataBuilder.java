package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;

public class VehiculoCarrionDataBuilder {

    private Long id;
    private Long idConductor;
    private String placa;
    private String numeroMotor;
    private String numeroChasis;
    private Long toneladas;
    private Long tipoVehiculo;
    private Long modelo;
    private String marca;

    public VehiculoCarrionDataBuilder() {
        idConductor=1L;
        placa="QHM980";
        numeroMotor="12HSTY56";
        numeroChasis="6726HAJSK";
        toneladas=1L;
        tipoVehiculo=1L;
        modelo=2024L;
        marca="Nissan";
    }

    public VehiculoCarrionDataBuilder conNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
        return this;
    }

    public VehiculoCarrionDataBuilder conNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
        return this;
    }

    public VehiculoCarrionDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoCarrionDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public DtoVehiculoCarrion buildDto() {
        return new DtoVehiculoCarrion(id,idConductor, placa,numeroMotor,numeroChasis,toneladas,
                tipoVehiculo,modelo,marca);
    }
    public VehiculoCarrion build() {
        return new VehiculoCarrion(id,idConductor, placa,numeroMotor,numeroChasis,toneladas,
                tipoVehiculo,modelo,marca);
    }
}
