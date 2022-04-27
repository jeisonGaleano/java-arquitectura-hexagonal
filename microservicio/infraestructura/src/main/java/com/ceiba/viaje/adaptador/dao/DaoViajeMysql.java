package com.ceiba.viaje.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import com.ceiba.viajes.puerto.dao.DaoViaje;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoViajeMysql implements DaoViaje {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoViajeMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="viaje_carrion", value="listar_activos_conductor")
    private static String sqlListarActivosPorConductor;

    @SqlStatement(namespace="viaje_carrion", value="listar_viajes_conductor")
    private static String sqlListarViajesPorConductor;

    @SqlStatement(namespace="viaje_carrion", value="listar_viajes_cliente")
    private static String sqlListarViajesPorCliente;

    @Override
    public List<DtoViaje> listarViajesActivosPorConductor(Long idConductor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idConductor", idConductor);
        paramSource.addValue("terminado", false);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                query(sqlListarActivosPorConductor, paramSource, new MapeoViaje());
    }

    @Override
    public List<DtoViaje> listarViajesPorConductor(Long idConductor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idConductor", idConductor);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                query(sqlListarActivosPorConductor, paramSource, new MapeoViaje());
    }

    @Override
    public List<DtoViaje> listarPeticionesViajesPorCliente(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                query(sqlListarActivosPorConductor, paramSource, new MapeoViaje());
    }
}
