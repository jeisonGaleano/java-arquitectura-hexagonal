package com.ceiba.configuracion;

import com.ceiba.viajes.puerto.repositorio.RepositorioViaje;
import com.ceiba.viajes.servicio.ServicioActualizarViaje;
import com.ceiba.viajes.servicio.ServicioCrearViaje;
import com.ceiba.viajes.servicio.ServicioEliminarViaje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanViaje {

    @Bean
    public ServicioCrearViaje servicioCrearViaje(RepositorioViaje repositorioViaje) {
        return new ServicioCrearViaje(repositorioViaje);
    }

    @Bean
    public ServicioActualizarViaje servicioActualizarViaje(RepositorioViaje repositorioViaje) {
        return new ServicioActualizarViaje(repositorioViaje);
    }

    @Bean
    public ServicioEliminarViaje servicioEliminarViaje(RepositorioViaje repositorioViaje) {
        return new ServicioEliminarViaje(repositorioViaje);
    }
}
