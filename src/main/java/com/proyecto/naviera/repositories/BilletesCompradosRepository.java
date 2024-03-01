package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.BilletesComprados;

public interface BilletesCompradosRepository extends MongoRepository<BilletesComprados,String> {
     public abstract ArrayList<BilletesComprados> findAll(); 
}
