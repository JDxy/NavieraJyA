package com.proyecto.naviera.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
