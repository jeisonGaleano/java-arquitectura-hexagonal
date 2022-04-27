package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class UsuarioCarrion {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificacion de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;
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

    public UsuarioCarrion(Long id, Long identificacion, String nombre, String apellido,
                          String usuario, String clave, Long edad, Long tipoRol, String ciudadResidencia,
                          String correoElectronico, LocalDateTime fechaCreacion) {

        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

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
