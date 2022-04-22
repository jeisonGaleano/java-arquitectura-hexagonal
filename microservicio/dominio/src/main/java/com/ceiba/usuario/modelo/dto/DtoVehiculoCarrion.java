package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoVehiculoCarrion {

    private Long id;
    private Long identificacion;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private Long edad;
    private Long tipo_rol;
    private String ciudad_residencia;
    private String correo_electronico;
    private LocalDate fecha_creacion;
}
