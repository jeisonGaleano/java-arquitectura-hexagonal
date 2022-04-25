package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoVehiculo  implements RowMapper<DtoVehiculoCarrion>, MapperResult {
    @Override
    public DtoVehiculoCarrion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long identificacion = rs.getLong("id_conductor");
        String placa = rs.getString("placa");
        String numeroMotor = rs.getString("numero_motor");
        String numeroChasis = rs.getString("numero_chasis");
        Long toneladas = rs.getLong("toneladas");
        Long tipoVehiculo = rs.getLong("tipo_vehiculo");
        Long modelo = rs.getLong("modelo");
        String marca = rs.getString("marca");

        return new DtoVehiculoCarrion(id,identificacion, placa,numeroMotor,numeroChasis,toneladas, tipoVehiculo,
                modelo,marca);
    }
}
