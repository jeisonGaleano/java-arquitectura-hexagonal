package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.fabrica.FabricaVehiculo;
import com.ceiba.vehiculo.modelo.entidad.VehiculoCarrion;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarVehiculo implements ManejadorComando<ComandoVehiculo> {


    private final FabricaVehiculo fabricaVehiculo;

    private final ServicioActualizarVehiculo servicioCrearVehiculo;

    public ManejadorActualizarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioActualizarVehiculo servicioActualizarVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioCrearVehiculo = servicioActualizarVehiculo;
    }

    @Override
    public void ejecutar(ComandoVehiculo comando) {
        VehiculoCarrion vehiculoCarrion = this.fabricaVehiculo.crearVehiculo(comando);
        this.servicioCrearVehiculo.ejecutar(vehiculoCarrion);
    }
}
