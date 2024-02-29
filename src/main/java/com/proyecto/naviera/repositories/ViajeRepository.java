package com.proyecto.naviera.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.naviera.model.Viaje;

public interface ViajeRepository extends MongoRepository<Viaje,String>{           
        public abstract ArrayList<Viaje> findAll(); 
        public abstract ArrayList<Viaje> findByDestino(String destino);
        public abstract Viaje save(Viaje viaje);
}
