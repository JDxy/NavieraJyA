package com.proyecto.naviera.repositories;

import java.util.ArrayList;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Trip;

public interface TripRepository extends MongoRepository<Trip,String>{
    public abstract ArrayList<Trip> findAll();  
    public abstract ArrayList<Trip> findByEscala(int escala);
    public abstract ArrayList<Trip> findByOrigen(String origen);
    public abstract ArrayList<Trip> findByOrigenAndDestino(String origen, String destino);
    @SuppressWarnings("unchecked")
    public abstract Trip save(Trip trip);
    public abstract void deleteByNombre(String nombre);   
    //para el update-->
    public abstract Trip findTripById(String id);
}
