package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.naviera.DTO.ViajeDTO;
import com.proyecto.naviera.model.Viaje;
import com.proyecto.naviera.repositories.ViajeRepository;

/**
 * Clase que proporciona servicios relacionados con los viajes.
 */
@Service
public class ViajeService {
  
    @Autowired //-> es la inyeccion de dependencias
    private ViajeRepository viajeRepository;

    /**
     * Obtiene todos los viajes.
     * @return Lista de todos los viajes.
     */
    public ArrayList<Viaje> getAllViajes() {
      return viajeRepository.findAll();
    }

    /**
     * Obtiene los viajes por destino.
     * @param destino El destino de los viajes a buscar.
     * @return Lista de viajes con el destino especificado.
     */
    public ArrayList<Viaje> getViajesByDestino(String destino) {
      return viajeRepository.findByDestino(destino);
    }


    /**
     * Obtiene los viajes por procedencia.
     * @param procedencia La procedencia de los viajes a buscar.
     * @return Lista de viajes con la procedencia especificada.
     */
    public ArrayList<Viaje> getViajesByProcedencia(String procedencia) {
      return viajeRepository.findByProcedencia(procedencia);
    }

    /**
     * Registra un nuevo viaje.
     * @param viajeDTO La información del nuevo viaje.
     */
    public void postRegisterViaje(ViajeDTO viajeDTO) {
        Viaje viaje = new Viaje();
        if (viajeDTO.getProcedencia() != null && viajeDTO.getDestino() != null) {
            viaje.setId(viajeDTO.getId());
            viaje.setPrecio(viajeDTO.getPrecio());
            viaje.setFecha_salida(viajeDTO.getFecha_salida());
            viaje.setFecha_llegada(viajeDTO.getFecha_llegada());
            viaje.setDestino(viajeDTO.getDestino());
            viaje.setProcedencia(viajeDTO.getProcedencia());
            viaje.setPlazas_turista(viajeDTO.getPlazas_turista());
            viaje.setPlazas_primera(viajeDTO.getPlazas_primera());
            viajeRepository.save(viaje);
        }
    }

   /**
     * Elimina un viaje por su ID.
     * @param id El ID del viaje a eliminar.
     */
    public void deleteViaje(String id){
      viajeRepository.deleteById(id);
    }

    /**
     * Actualiza el destino de un viaje.
     * @param id El ID del viaje a actualizar.
     * @param viajeDTO La nueva información del viaje.
     */
    public void updateViajeDestino(String id, ViajeDTO viajeDTO) {
      Viaje viaje=viajeRepository.findViajeById(id);
      if(viaje!=null){
        viaje.setDestino(viajeDTO.getDestino());
        viajeRepository.save(viaje);
      }     
    }

    /**
     * Busca viajes en un rango de precios.
     * @param precioMinimo Precio mínimo del rango.
     * @param precioMaximo Precio máximo del rango.
     * @return Lista de viajes en el rango de precios especificado.
     */
    public ArrayList<Viaje> buscarViajesRangoPorPrecio(int precioMinimo, int precioMaximo) {
      return viajeRepository.findByPrecioBetween(precioMinimo, precioMaximo);
    }

}
