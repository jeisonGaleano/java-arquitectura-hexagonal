package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuarioCarrion servicioCrearUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuarioCarrion){
        return new ServicioCrearUsuarioCarrion(repositorioUsuarioCarrion);
    }

    @Bean
    public ServicioActualizarUsuarioCarrion servicioActualizarUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuarioCarrion){
        return new ServicioActualizarUsuarioCarrion(repositorioUsuarioCarrion);
    }

    @Bean
    public ServicioEliminarUsuarioCarrion servicioEliminarUsuarioCarrion(RepositorioUsuarioCarrion repositorioUsuarioCarrion){
        return new ServicioEliminarUsuarioCarrion(repositorioUsuarioCarrion);
    }


}
