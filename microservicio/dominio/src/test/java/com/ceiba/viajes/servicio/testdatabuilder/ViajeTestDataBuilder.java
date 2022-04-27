package com.ceiba.viajes.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoCarrionDataBuilder;
import com.ceiba.viajes.modelo.dto.DtoViaje;
import com.ceiba.viajes.modelo.entidad.Viaje;

import java.time.LocalDateTime;

public class ViajeTestDataBuilder {

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


    public ViajeTestDataBuilder() {
        id=1L;
        idUsuario=1L;
        idConductor=2L;
        tonelads=10L;
        tipoVehiculo=1L;
        fechaCreacion=LocalDateTime.parse("2022-05-01T09:02:26.658");
        fechaServicio=fechaCreacion.plusDays(1);
        origen="Barranquilla";
        destino="Santa Marta";
        terminado=true;
        tipoCasa="condominio";
        precio=100000L;
    }
    public ViajeTestDataBuilder conFechaServicio(LocalDateTime fechaServicio) {
        this.fechaServicio = fechaServicio;
        return this;
    }

    public ViajeTestDataBuilder conFechaServicioYTipoDeCasa(LocalDateTime fechaServicio, String tipoCasa) {
        this.fechaServicio = fechaServicio;
        this.tipoCasa = tipoCasa;
        return this;
    }

    public ViajeTestDataBuilder conPorcentajeFinDeSemana(LocalDateTime fechaServicio, Long precio) {
        this.fechaServicio = fechaServicio;
        this.precio = precio;
        return this;
    }

    public ViajeTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ViajeTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ViajeTestDataBuilder conIdConductor(Long idConductor) {
        this.idConductor = idConductor;
        return this;
    }

    public DtoViaje buildDto() {
        return new DtoViaje(id,idUsuario,idConductor,tonelads,tipoVehiculo,fechaCreacion,fechaServicio,
                origen,destino,terminado,tipoCasa,precio);
    }

    public Viaje build() {
        return new Viaje(id,idUsuario,idConductor,tonelads,tipoVehiculo,fechaCreacion,fechaServicio,
                origen,destino,terminado,tipoCasa,precio);
    }

}
