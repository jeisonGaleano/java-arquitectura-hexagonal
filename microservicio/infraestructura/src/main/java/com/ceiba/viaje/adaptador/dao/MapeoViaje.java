package com.ceiba.viaje.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoViaje implements RowMapper<DtoViaje>, MapperResult {


    @Override
    public DtoViaje mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idUsuario = rs.getLong("id_usuario");
        Long idConductor = rs.getLong("id_conductor");
        Long toneladas = rs.getLong("numero_motor");
        Long tipoVehiculo = rs.getLong("numero_chasis");
        LocalDateTime fechaCreacion = LocalDateTime.parse(rs.getString("toneladas"));
        LocalDateTime fechaServicio = LocalDateTime.parse(rs.getString("tipo_vehiculo"));
        String origen = rs.getString("modelo");
        String destino = rs.getString("marca");
        boolean terminado = rs.getBoolean("terminado");
        String tipoCasa = rs.getString("tipo_casa");
        Long precio = rs.getLong("precio");
        return new DtoViaje(id,idUsuario,idConductor,toneladas,
                tipoVehiculo,fechaCreacion,fechaServicio,origen,destino,terminado,tipoCasa, precio);
    }
}
