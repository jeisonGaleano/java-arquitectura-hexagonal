package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class RolesCarrion {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_ROL = "Se debe ingresar el nombre de rol";

    private Long id;
    private String nombreRol;

    public RolesCarrion(Long id, String nombreRol) {
        validarObligatorio(nombreRol, SE_DEBE_INGRESAR_EL_NOMBRE_DE_ROL);
        this.id = id;
        this.nombreRol = nombreRol;
    }
}
