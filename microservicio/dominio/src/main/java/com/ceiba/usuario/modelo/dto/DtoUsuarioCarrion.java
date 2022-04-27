package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuarioCarrion {

    private Long id;
    @NotNull(message = "La identificacion del conductor es obligatorio")
    private Long identificacion;
    private String nombre;
    private String apellido;
    @NotNull(message = "El usuario es obligatorio")
    private String usuario;
    @Size(min = 4, message = "Debe tener minimo 4 caracteres")
    @NotNull(message = "La clave es obligatorio")
    private String clave;
    private Long edad;
    private Long tipoRol;
    private String ciudadResidencia;
    private String correoElectronico;
    private LocalDateTime fechaCreacion;

}
