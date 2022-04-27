package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuarioCarrion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoUsuarioCarrion implements RowMapper<DtoUsuarioCarrion>, MapperResult {
    @Override
    public DtoUsuarioCarrion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long identificacion = rs.getLong("identificacion");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Long edad = rs.getLong("edad");
        Long tipoRol = rs.getLong("tipo_rol");
        String ciudadResidencia = rs.getString("ciudad_residencia");
        String correoElectronico = rs.getString("correo_electronico");
        String usuario = rs.getString("usuario");
        String clave = rs.getString("clave");
        LocalDateTime fecha = extraerLocalDateTime(rs, "fecha_creacion");

        return new DtoUsuarioCarrion(id,identificacion,nombre,apellido,usuario,clave,edad,
                tipoRol,ciudadResidencia,correoElectronico,fecha);

    }
}
