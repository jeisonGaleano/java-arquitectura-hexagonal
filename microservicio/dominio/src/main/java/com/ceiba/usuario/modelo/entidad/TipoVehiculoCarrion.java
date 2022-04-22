package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoVehiculoCarrion {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_TIPO_VEHICULO = "Se debe ingresar el nombre de rol";

    private Long id;
    private String nombreTipoVehiculo;

    public TipoVehiculoCarrion(Long id, String nombreTipoVehiculo) {
        validarObligatorio(nombreTipoVehiculo, SE_DEBE_INGRESAR_EL_NOMBRE_DE_TIPO_VEHICULO);
        this.id = id;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }
}
