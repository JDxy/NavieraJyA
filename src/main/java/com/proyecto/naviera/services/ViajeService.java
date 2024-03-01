package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.naviera.DTO.ViajeDTO;
import com.proyecto.naviera.model.Viaje;
import com.proyecto.naviera.repositories.ViajeRepository;

@Service
public class ViajeService {
  
    @Autowired //-> es la inyeccion de dependencias
    private ViajeRepository viajeRepository;

    public ArrayList<Viaje> getAllViajes() {
      return viajeRepository.findAll();
    }

    public ArrayList<Viaje> getViajesByDestino(String destino) {
      return viajeRepository.findByDestino(destino);
    }

    public ArrayList<Viaje> getViajesByProcedencia(String procedencia) {
      return viajeRepository.findByProcedencia(procedencia);
    }

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

    public void deleteViaje(String id){
      viajeRepository.deleteById(id);
    }

    public void updateViajeDestino(String id, ViajeDTO viajeDTO) {
      Viaje viaje=viajeRepository.findViajeById(id);
      if(viaje!=null){
        viaje.setDestino(viajeDTO.getDestino());
        viajeRepository.save(viaje);
      }     
    }

}
