package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.naviera.model.BilletesComprados;
import com.proyecto.naviera.repositories.BilletesCompradosRepository;

@Service
public class BilletesCompradosService {
    @Autowired //-> es la inyeccion de dependencias
    private BilletesCompradosRepository billetesCompradosRepository;

    public ArrayList<BilletesComprados> getAllBilletesComprados() {
      return billetesCompradosRepository.findAll();
    }
}
