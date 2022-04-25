package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculoCarrion;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DaoVehiculoMysql implements DaoVehiculo {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoVehiculoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="vehiculo_carrion", value="listar")
    private static String sqlListar;

    @Override
    public List<DtoVehiculoCarrion> listarVehiculoPorConductor(Long identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                query(sqlListar, paramSource, new MapeoVehiculo());
    }
}
