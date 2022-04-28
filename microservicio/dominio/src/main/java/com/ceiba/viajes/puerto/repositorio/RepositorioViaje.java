package com.ceiba.viajes.puerto.repositorio;


import com.ceiba.viajes.modelo.entidad.Viaje;

import java.time.LocalDateTime;

public interface RepositorioViaje {

    Long crear(Viaje viaje);

    void actualizar(Viaje viaje);

    void eliminar(Long id);

    boolean existeViaje(Long idConductor, Long idUsuario, boolean terminado);

}
