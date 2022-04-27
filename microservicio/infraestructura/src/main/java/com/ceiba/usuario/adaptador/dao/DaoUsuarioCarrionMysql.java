package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoUsuarioCarrion;
import com.ceiba.usuario.puerto.dao.DaoUsuarioCarrion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoUsuarioCarrionMysql implements DaoUsuarioCarrion {

    @SqlStatement(namespace="usuario_carrion", value="listar")
    private static String sqlListar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoUsuarioCarrionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoUsuarioCarrion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoUsuarioCarrion());
    }
}
