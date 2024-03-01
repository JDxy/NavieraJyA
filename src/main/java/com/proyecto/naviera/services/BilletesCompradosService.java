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

    /**
    * Método para obtener todos los billetes comprados en la base de datos.     *
    * @return Una lista de todos los billetes comprados.
    */
    public ArrayList<BilletesComprados> getAllBilletesComprados() {
        return (ArrayList<BilletesComprados>) billetesCompradosRepository.findAll();
    }
    
    /**
    * Método para encontrar los viajes asociados a una fecha específica en los billetes comprados.    *
    * @param fecha La fecha específica para la cual se buscarán los viajes.
    * @return Una lista de los viajes asociados a la fecha proporcionada.
    */
    public ArrayList<String> findViajesByFecha(String fecha) {
        return billetesCompradosRepository.findViajesByFecha(fecha);
    }

    /**
     * Método para eliminar billetes comprados por fecha
    */ 
     public void deleteBilletesByFecha(String fecha) {
        billetesCompradosRepository.deleteByFecha(fecha);
    }      
}
