package com.ceiba.viajes.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;
import org.joda.time.DateTimeConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Viaje {

    private static final String NO_SE_REALIZA_SERVICIO = "No se realizará servicio porque el lugar es condominio";
    private static final String NO_SE_REALIZA_SERVICIO_POR_FECHA = "No se puede agendar servicio para el mismo día";

    private static final Long PORCENTAJE_DESCUENTO=5L;

    private static final String CONDOMINIO="condominio";

    private static final String SE_DEBE_INGRESAR_EL_ID_USUARIO = "Se debe ingresar el id usuario";

    private static final String SE_DEBE_INGRESAR_EL_ID_CONDUCTOR = "Se debe ingresar el id conductor";

    private Long id;
    private Long idUsuario;
    private Long idConductor;
    private Long toneladas;
    private Long tipoVehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaServicio;
    private String origen;
    private String destino;
    private Boolean terminado;
    private String tipoCasa;
    private Long precio;

    public Viaje(Long id, Long idUsuario, Long idConductor, Long toneladas, Long tipoVehiculo,
                 LocalDateTime fechaCreacion, LocalDateTime fechaServicio, String origen,
                 String destino, Boolean terminado, String tipoCasa, Long precio) {
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_USUARIO);
        validarObligatorio(idConductor, SE_DEBE_INGRESAR_EL_ID_CONDUCTOR);

        validarAnterioridadViaje(fechaServicio);
        validarViajesACondominio(fechaServicio,tipoCasa);
        this.id = id;
        this.idUsuario = idUsuario;
        this.idConductor = idConductor;
        this.toneladas = toneladas;
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
        LocalDate fechaInicialServicio = LocalDate.of(fechaServicio.getYear(), fechaServicio.getMonth(), fechaServicio.getDayOfMonth());
        int dia = fechaInicialServicio.getDayOfWeek().getValue();
        if (DateTimeConstants.SATURDAY == dia || DateTimeConstants.SUNDAY == dia) {
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
        if (tipoCasa.equalsIgnoreCase(CONDOMINIO) && validarFecha(fechaServicio)){
            throw new ExcepcionValorInvalido(NO_SE_REALIZA_SERVICIO);
        }
    }
    private void validarAnterioridadViaje(LocalDateTime fechaServicio){
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime localDateTime= LocalDateTime.now();
        if (localDateTime.format(dtformat).equals(fechaServicio.format(dtformat))){
            throw new ExcepcionValorInvalido(NO_SE_REALIZA_SERVICIO_POR_FECHA);
        }
    }
}
