package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.dto.DtoUsuarioCarrion;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;

import java.time.LocalDateTime;

public class UsuarioCarrionTestDataBuilder {

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

    public UsuarioCarrionTestDataBuilder() {
        identificacion=123456789L;
        nombre="Jeison";
        apellido="Galeano";
        usuario="Json";
        clave="1234";
        edad=22L;
        tipoRol=1L;
        ciudadResidencia="Barranquilla";
        correoElectronico="jeison.galeano@gmail.com";
        fechaCreacion=LocalDateTime.now();
    }
    public UsuarioCarrionTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioCarrionTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioCarrionTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }



    public UsuarioCarrionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioCarrionTestDataBuilder conIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioCarrionTestDataBuilder conUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public DtoUsuarioCarrion buildDto() {
        return new DtoUsuarioCarrion(id,identificacion, nombre,apellido,usuario,clave,edad,tipoRol,ciudadResidencia,correoElectronico,fechaCreacion);
    }

    public UsuarioCarrion build() {
        return new UsuarioCarrion(id,identificacion, nombre,apellido,usuario,clave,edad,tipoRol,ciudadResidencia,correoElectronico,fechaCreacion);
    }

}
