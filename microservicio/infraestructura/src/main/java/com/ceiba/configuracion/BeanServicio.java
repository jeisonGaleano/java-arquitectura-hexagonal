package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioCarrion;
import com.ceiba.usuario.servicio.*;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }


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
