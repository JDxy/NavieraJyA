package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.naviera.model.BilletesComprados;
import com.proyecto.naviera.repositories.BilletesCompradosRepository;

@Service
public class BilletesCompradosService {
    @Autowired
    private BilletesCompradosRepository billetesCompradosRepository;

    public ArrayList<BilletesComprados> getAllBilletesComprados() {
        return (ArrayList<BilletesComprados>) billetesCompradosRepository.findAll();
    }

    // Puedes agregar métodos adicionales según sea necesario, por ejemplo:
    public ArrayList<String> findViajesByFecha(String fecha) {
        return billetesCompradosRepository.findViajesByFecha(fecha);
    }
}
