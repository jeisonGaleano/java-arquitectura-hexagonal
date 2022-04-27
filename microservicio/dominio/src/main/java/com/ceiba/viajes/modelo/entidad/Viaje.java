package com.ceiba.viajes.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Getter
public class Viaje {

    private static final String NO_SE_REALIZA_SERVICIO = "No se realizará servicio porque el lugar es condominio";
    private static final String NO_SE_REALIZA_SERVICIO_POR_FECHA = "No se puede agendar servicio para el mismo día";

    private static final Long PORCENTAJE_DESCUENTO=5L;

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

    public Viaje(Long id, Long idUsuario, Long idConductor, Long tonelads, Long tipoVehiculo,
                 LocalDateTime fechaCreacion, LocalDateTime fechaServicio, String origen,
                 String destino, Boolean terminado, String tipoCasa, Long precio) {
        validarAnterioridadViaje(fechaServicio);
        validarViajesACondominio(fechaServicio,tipoCasa);
        this.id = id;
        this.idUsuario = idUsuario;
        this.idConductor = idConductor;
        this.tonelads = tonelads;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaCreacion = fechaCreacion;
        this.fechaServicio = fechaServicio;
        this.origen = origen;
        this.destino = destino;
        this.terminado = terminado;
        this.tipoCasa = tipoCasa;
        this.precio = porcentajePrecio(fechaServicio, precio);
    }

    private boolean validarFecha(LocalDateTime fechaServicio){
        boolean estado=false;
        Date fechaFormateada = Date.from(fechaServicio.atZone(ZoneId.systemDefault()).toInstant());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fechaFormateada);
        if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
            estado=true;
        }
        return estado;
    }


    private Long porcentajePrecio(LocalDateTime fechaServicio, Long precio){
        Long valorPorcentaje=0L;
        if (validarFecha(fechaServicio)){
            valorPorcentaje= ((precio/100)*PORCENTAJE_DESCUENTO);
        }
        return valorPorcentaje+precio;
    }

    private void validarViajesACondominio(LocalDateTime fechaServicio, String tipoCasa){
        if (tipoCasa.equalsIgnoreCase("condominio") && validarFecha(fechaServicio)){
            throw new ExcepcionValorInvalido(NO_SE_REALIZA_SERVICIO);
        }
    }
    private void validarAnterioridadViaje(LocalDateTime fechaServicio){
        LocalDateTime localDateTime= LocalDateTime.now();
        if (localDateTime.isEqual(fechaServicio)){
            throw new ExcepcionValorInvalido(NO_SE_REALIZA_SERVICIO_POR_FECHA);
        }
    }
}
