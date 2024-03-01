package com.proyecto.naviera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.BilletesComprados;

/**
 * BilletesCompradosRepository
 * No se necesita agregar nada aquí.
 * Se herendan los métodos basicos de MongoRepository y los métodos personalizados de CustomBilletesCompradosRepository
 */
public interface BilletesCompradosRepository extends MongoRepository<BilletesComprados,String>, CustomBilletesCompradosRepository {   
}
