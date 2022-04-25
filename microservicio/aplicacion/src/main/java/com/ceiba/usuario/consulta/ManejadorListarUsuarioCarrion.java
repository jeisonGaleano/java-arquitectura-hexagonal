package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoUsuarioCarrion;
import com.ceiba.usuario.puerto.dao.DaoUsuarioCarrion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarUsuarioCarrion {

    private final DaoUsuarioCarrion daoUsuarioCarrion;

    public ManejadorListarUsuarioCarrion(DaoUsuarioCarrion daoUsuarioCarrion) {
        this.daoUsuarioCarrion = daoUsuarioCarrion;
    }

    public List<DtoUsuarioCarrion> ejecutar(){ return this.daoUsuarioCarrion.listar(); }

}
