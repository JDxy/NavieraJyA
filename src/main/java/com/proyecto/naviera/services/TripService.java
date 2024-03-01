package com.proyecto.naviera.services;

import java.util.ArrayList;
import com.proyecto.naviera.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.naviera.DTO.TripDTO;
import com.proyecto.naviera.model.Trip;

@Service
public class TripService {
    
    @Autowired //-> es la inyeccion de dependencias
    private TripRepository tripRepository;

    public ArrayList<Trip> getAllTrips() {
      return tripRepository.findAll();
    }

    public ArrayList<Trip> getTripsByEscala(int escala) {
      return tripRepository.findByEscala(escala);
    }

    public ArrayList<Trip> getTripsByOrigen(String origen) {
      return tripRepository.findByOrigen(origen);
    }

    public ArrayList<Trip> getTripsByOrigen2(String origen) {
      return tripRepository.findByOrigen(origen);
    }

    public ArrayList<Trip> getTripOrigenDestino(String origen, String destino) {
      return tripRepository.findByOrigenAndDestino(origen,destino);
    }

    public void postRegisterTrip(TripDTO tripDTO) {

      Trip trip=new Trip();

      if(tripDTO.getNombre()!=null &&
         tripDTO.getOrigen()!=null &&
         tripDTO.getDestino()!=null 
         ){
            trip.setNombre(tripDTO.getNombre());
            trip.setOrigen(tripDTO.getOrigen());
            trip.setDestino(tripDTO.getDestino());
            trip.setEscala(tripDTO.getEscala());
            trip.setPrecio(tripDTO.getPrecio());
            tripRepository.save(trip);
         }         
    }   

    public void deleteTrips(String nombre){
      tripRepository.deleteByNombre(nombre);
    }

    public void updateTrip(String id, TripDTO tripDTO) {
      Trip trip=tripRepository.findTripById(id);
      if(trip!=null){
        trip.setPrecio(tripDTO.getPrecio());
        tripRepository.save(trip);
      }     
    }
}
