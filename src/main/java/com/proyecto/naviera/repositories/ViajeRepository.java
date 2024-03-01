package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Viaje;

public interface ViajeRepository extends MongoRepository<Viaje,String>{           
        public abstract ArrayList<Viaje> findAll(); 
        public abstract ArrayList<Viaje> findByDestino(String destino);
        public abstract ArrayList<Viaje> findByProcedencia(String procedencia);
        public abstract Viaje save(Viaje viaje);
        public abstract void deleteById(String id);   
        public abstract Viaje findViajeById(String id);
        public abstract ArrayList<Viaje> findByPrecioBetween(int precioMinimo, int precioMaximo);
}
