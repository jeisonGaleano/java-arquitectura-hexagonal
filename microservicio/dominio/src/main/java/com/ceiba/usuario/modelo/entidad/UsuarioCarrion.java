package com.ceiba.usuario.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCarrion {

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



}
