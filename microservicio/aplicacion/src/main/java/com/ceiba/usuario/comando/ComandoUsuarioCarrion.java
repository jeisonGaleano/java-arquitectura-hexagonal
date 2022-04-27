package com.ceiba.usuario.comando;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComandoUsuarioCarrion {

    private Long id;
    private Long identificacion;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private Long edad;
    private Long tipoRol;
    private String ciudadResidencia;
    private String correoElectronico;
    private LocalDateTime fechaCreacion;

    public ComandoUsuarioCarrion(Long id, Long identificacion, String nombre, String apellido, String usuario, Long edad, Long tipoRol, String ciudadResidencia, String correoElectronico, LocalDateTime fechaCreacion) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.edad = edad;
        this.tipoRol = tipoRol;
        this.ciudadResidencia = ciudadResidencia;
        this.correoElectronico = correoElectronico;
        this.fechaCreacion = fechaCreacion;
    }
}
