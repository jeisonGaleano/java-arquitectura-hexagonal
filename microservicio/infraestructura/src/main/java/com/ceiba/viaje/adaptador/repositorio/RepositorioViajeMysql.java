package com.ceiba.viaje.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.viajes.modelo.entidad.Viaje;
import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioViajeMysql implements RepositorioViaje {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "viaje_carrion", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "viaje_carrion", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "viaje_carrion", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="viaje_carrion", value="existe_viaje")
    private static String sqlExisteViajeActivo;

    public RepositorioViajeMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Viaje viaje) {
        return this.customNamedParameterJdbcTemplate.crear(viaje, sqlCrear);

    }

    @Override
    public void actualizar(Viaje viaje) {
        this.customNamedParameterJdbcTemplate.actualizar(viaje, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existeViaje(Long idConductor, Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idConductor", idConductor);
        paramSource.addValue("idUsuario", idUsuario);
        paramSource.addValue("terminado", false);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteViajeActivo,paramSource, Boolean.class);

    }
}
