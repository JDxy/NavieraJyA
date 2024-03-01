package com.proyecto.naviera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.BilletesComprados;

public interface BilletesCompradosRepository extends MongoRepository<BilletesComprados,String>, CustomBilletesCompradosRepository {
    // No necesitas agregar nada aquí, ya que heredas los métodos básicos de MongoRepository y los métodos personalizados de CustomBilletesCompradosRepository
}
