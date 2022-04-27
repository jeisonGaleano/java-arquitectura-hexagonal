package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class VehiculoCarrion {


    private static final String SE_DEBE_INGRESAR_EL_NUMERO_MOTOR = "Se debe ingresar numero de motor";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_CHASIS= "Se debe ingresar numero chasis";

    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";

    private static final int LONGITUD_MAX_CLAVE = 6;

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

        validarObligatorio(numeroMotor, SE_DEBE_INGRESAR_EL_NUMERO_MOTOR);
        validarObligatorio(numeroChasis, SE_DEBE_INGRESAR_EL_NUMERO_CHASIS);
        validarLongitud(placa, LONGITUD_MAX_CLAVE, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_MAX_CLAVE));

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
