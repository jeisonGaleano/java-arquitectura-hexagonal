package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuarioCarrion;

import java.time.LocalDateTime;

public class ComandoUsuarioCarrionTestDataBuilder {

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

    public ComandoUsuarioCarrionTestDataBuilder() {
        identificacion=1143171018L;
        nombre="Json";
        apellido="Galeano";
        clave="1234567890";
        edad=22L;
        tipoRol=1L;
        ciudadResidencia="Barranquilla";
        correoElectronico="Santa Marta";
        fechaCreacion=LocalDateTime.now();
    }

    public ComandoUsuarioCarrion build(){
        return new ComandoUsuarioCarrion(id,identificacion,nombre,apellido,
                clave,edad,tipoRol,ciudadResidencia,correoElectronico,fechaCreacion);
    }
}
