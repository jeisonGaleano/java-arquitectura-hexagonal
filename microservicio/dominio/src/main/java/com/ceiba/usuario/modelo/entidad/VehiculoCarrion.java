package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class VehiculoCarrion {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_CONDUCTOR = "Se debe ingresar la identificacion del conductor";
    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO = "Se debe ingresar la placa del vehiculo";
    private static final String SE_DEBE_INGRESAR_NUMERO_DE_MOTOR = "Se debe ingresar el número de motor del vehiculo";


    private Long id;
    private Long idConductor;
    private String placa;
    private String numeroMotor;
    private String numeroChasis;
    private Long toneladas;
    private Long tipoVehiculo;
    private Long modelo;
    private String marca;

    public VehiculoCarrion(Long id, Long idConductor, String placa, String numeroMotor,
                           String numeroChasis, Long toneladas, Long tipoVehiculo, Long modelo, String marca) {

        validarObligatorio(idConductor, SE_DEBE_INGRESAR_LA_IDENTIFICACION_CONDUCTOR);
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO);
        validarObligatorio(numeroMotor, SE_DEBE_INGRESAR_NUMERO_DE_MOTOR);

        this.id = id;
        this.idConductor = idConductor;
        this.placa = placa;
        this.numeroMotor = numeroMotor;
        this.numeroChasis = numeroChasis;
        this.toneladas = toneladas;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.marca = marca;
    }
}
