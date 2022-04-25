package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.UsuarioCarrion;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.fabrica.FabricaVehiculo;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVehiculo implements ManejadorComandoRespuesta<ComandoVehiculo, ComandoRespuesta<Long>> {


    private final FabricaVehiculo fabricaVehiculo;

    private final ServicioCrearVehiculo servicioCrearVehiculo;

    public ManejadorCrearVehiculo(FabricaVehiculo fabricaVehiculo, ServicioCrearVehiculo servicioCrearVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioCrearVehiculo = servicioCrearVehiculo;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comando) {
        VehiculoCarrion vehiculoCarrion = this.fabricaVehiculo.crearVehiculo(comando);
        return new ComandoRespuesta<>(this.servicioCrearVehiculo.ejecutar(vehiculoCarrion));
    }
}
