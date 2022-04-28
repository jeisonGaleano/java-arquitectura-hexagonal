package com.ceiba.viaje.servicio;

import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.viajes.comando.ComandoViaje;

import java.time.LocalDateTime;

public class ComandoViajeTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idConductor;
    private Long tonelads;
    private Long tipoVehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaServicio;
    private String origen;
    private String destino;
    private Boolean terminado;
    private String tipoCasa;
    private Long precio;

    public ComandoViajeTestDataBuilder() {
        id=1L;
        idUsuario=1L;
        idConductor=2L;
        tonelads=10L;
        tipoVehiculo=1L;
        fechaCreacion=LocalDateTime.now();
        fechaServicio=fechaCreacion.plusDays(1);
        origen="Barranquilla";
        destino="Santa Marta";
        terminado=false;
        tipoCasa="apto";
        precio=150000L;
    }

    public ComandoViaje build(){
        return new ComandoViaje(id,idUsuario,idConductor,tonelads,tipoVehiculo,fechaCreacion,fechaServicio,
                origen,destino,terminado,tipoCasa,precio);
    }
}
