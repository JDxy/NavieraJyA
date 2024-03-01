package com.proyecto.naviera.controller;

import com.proyecto.naviera.services.TripService;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.naviera.DTO.TripDTO;
import com.proyecto.naviera.model.Trip;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/trip")
public class TripController {
    
    @Autowired
    private TripService tripService;

    @GetMapping()
    public ArrayList<Trip> getAllTrips(){
            return tripService.getAllTrips();
    }
    //localhost:9010/trip/4
    @GetMapping("/{escala}")
    public ArrayList<Trip> getTripsByEscala(@PathVariable("escala") int escala) {
        return tripService.getTripsByEscala(escala);
    }
    //localhost:9010/trip/origen:Holanda
    @GetMapping("/origen:{origen}")
    public ArrayList<Trip> getTripsByOrigen(@PathVariable("origen") String origen) {
        return tripService.getTripsByOrigen(origen);
    }
    //localhost:9010/trip/origen2:Holanda
    @GetMapping("/origen2:{origen}")
    public ArrayList<Trip> getTripsByOrigen2(@RequestParam(name = "origen", required =false, defaultValue = "Las Palmas") String origen) {
        return tripService.getTripsByOrigen(origen);
    }
    //localhost:9010/trip/origen-destino?origen=China&destino=Japon
    @GetMapping("/origen-destino")
    public ArrayList<Trip> getTripOrigenDestino(@RequestParam(name = "origen", required = false, defaultValue = "Las Palmas") String origen, @RequestParam(name = "destino", required = false, defaultValue = "Las Palmas") String destino) {
        return tripService.getTripOrigenDestino(origen, destino);
    }
    /*
    * @PostMapping() y @RequestBody
    * registrar viaje 
    En el postman: post localhost:9010/trip/AddTrip 
    --> body --> JSON    
    {
    "nombre":"Inframundo",
    "origen":"La Tierra",
    "destino":"Inferno",
    "escala":1,
    "duracion":20,
    "precio":0.0
    }
    */
   @PostMapping("AddTrip")
   public void postRegisterTrip(@RequestBody TripDTO trip) {     
    tripService.postRegisterTrip(trip);
   }

   @DeleteMapping("/{nombre}")
    public void deleteTrips(@PathVariable("nombre") String nombre){
        tripService.deleteTrips(nombre);
    }

    /*
     * @PutMapping("modify/{id}")
     * y @PathVariable String id, 
     * @RequestBody Trip trip
     * actualizar viajes
     * que retorne
     */
    @PutMapping("path/{id}")
    public void putTripPrecio(@PathVariable String id, @RequestBody TripDTO trip) {
        tripService.updateTrip(id, trip);
    }
}
