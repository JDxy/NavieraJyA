package com.proyecto.naviera.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.naviera.DTO.ViajeDTO;
import com.proyecto.naviera.model.Viaje;
import com.proyecto.naviera.services.ViajeService;

@RestController
@RequestMapping("/viaje")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping()
    public ArrayList<Viaje> getAllViajes(){
        return viajeService.getAllViajes();
    }

    @GetMapping("/destino:{destino}")
    public ArrayList<Viaje> getViajesByDestino(@PathVariable("destino") String destino) {
        return viajeService.getViajesByDestino(destino);
    }

    // localhost:9001/viaje/procedencia?procedencia=Fuerteventura
    @GetMapping("/procedencia")
    public ArrayList<Viaje> getViajesByProcedencia(@RequestParam(name = "procedencia", required = false, defaultValue = "Tenerife") String procedencia) {
        return viajeService.getViajesByProcedencia(procedencia);
    }
    
    /* 
    @GetMapping("/destino2:{destino}")
    public ArrayList<Viaje> getViajesByDestino2(@RequestParam(name = "destino", required = false, defaultValue = "Tenerife") String destino) {
        return viajeService.getViajesByDestino(destino);
    }
    */

    /*
    En el postman: post localhost:9001/viaje/addviaje
    --> body --> JSON (raw)
    {
    "id":"tf08",
    "precio": 80,
    "fecha_salida": "2023-12-22 09:00:00",
    "fecha_llegada": "2023-12-22 11:00:00",
    "destino": "Tenerife",
    "procedencia": "Gran Canaria",
    "plazas_turista": 450,
    "plazas_primera": 69
    }
    */
    @PostMapping("addviaje")
    public void postRegisterViaje(@RequestBody ViajeDTO viaje) {     
        viajeService.postRegisterViaje(viaje);
    }

    @DeleteMapping("/delete:{id}")
    public void deleteViaje(@PathVariable("id") String id){
        viajeService.deleteViaje(id);
    }

    @PutMapping("nuevodestino/{id}")
    public void putViajeDestino(@PathVariable String id, @RequestBody ViajeDTO viaje) {
        viajeService.updateViajeDestino(id, viaje);
    }
}
