package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Viaje;


/**
 * Interfaz para el repositorio de viajes.
 */
public interface ViajeRepository extends MongoRepository<Viaje,String>{

        /**
     * Encuentra todos los viajes.
     * @return Lista de todos los viajes.
     */
    public abstract ArrayList<Viaje> findAll();

    /**
     * Encuentra los viajes por destino.
     * @param destino El destino de los viajes a buscar.
     * @return Lista de viajes con el destino especificado.
     */
    public abstract ArrayList<Viaje> findByDestino(String destino);

    /**
     * Encuentra los viajes por procedencia.
     * @param procedencia La procedencia de los viajes a buscar.
     * @return Lista de viajes con la procedencia especificada.
     */
    public abstract ArrayList<Viaje> findByProcedencia(String procedencia);

    /**
     * Guarda un viaje.
     * @param viaje El viaje a guardar.
     * @return El viaje guardado.
     */
    public abstract Viaje save(Viaje viaje);

    /**
     * Elimina un viaje por su ID.
     * @param id El ID del viaje a eliminar.
     */
    public abstract void deleteById(String id);

    /**
     * Encuentra un viaje por su ID.
     * @param id El ID del viaje a encontrar.
     * @return El viaje encontrado, o null si no se encuentra.
     */
    public abstract Viaje findViajeById(String id);

    /**
     * Encuentra los viajes cuyo precio esté dentro de un rango especificado.
     * @param precioMinimo El precio mínimo del rango.
     * @param precioMaximo El precio máximo del rango.
     * @return Lista de viajes cuyo precio esté dentro del rango especificado.
     */
    public abstract ArrayList<Viaje> findByPrecioBetween(int precioMinimo, int precioMaximo);
}
