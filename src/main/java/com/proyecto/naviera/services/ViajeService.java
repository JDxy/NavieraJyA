package com.proyecto.naviera.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.naviera.DTO.TripDTO;
import com.proyecto.naviera.DTO.ViajeDTO;
import com.proyecto.naviera.model.Trip;
import com.proyecto.naviera.model.Viaje;
import com.proyecto.naviera.repositories.ViajeRepository;


@Service
public class ViajeService {
       @Autowired //-> es la inyeccion de dependencias
    private ViajeRepository viajeRepository;

    public ArrayList<Viaje> getAllViajes() {
      return viajeRepository.findAll();
    }

    public ArrayList<Viaje> getViajesByDestino(String destino) {
      return viajeRepository.findByDestino(destino);
    }

  public void postRegisterViaje(ViajeDTO viajeDTO) {
        Viaje viaje = new Viaje();

        if (viajeDTO.getProcedencia() != null && viajeDTO.getDestino() != null) {
            viaje.setPrecio(viajeDTO.getPrecio());
            viaje.setFecha_salida(viajeDTO.getFecha_salida());
            viaje.setFecha_llegada(viajeDTO.getFecha_llegada());
            viaje.setDestino(viajeDTO.getDestino());
            viaje.setProcedencia(viajeDTO.getProcedencia());
            viaje.setPlazas_turista(viajeDTO.getPlazas_turista());
            viaje.setPlazas_primera(viajeDTO.getPlazas_primera());
            viaje.setId(viajeDTO.getId());
            viajeRepository.save(viaje);
        }
    }

}
