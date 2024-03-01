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


/**
 * Controlador para la gestión de viajes.
 */
@RestController
@RequestMapping("/viaje")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    /**
     * Método para obtener todos los viajes.
     * @return Lista de todos los viajes.
     */
    @GetMapping()
    public ArrayList<Viaje> getAllViajes(){
        return viajeService.getAllViajes();
    }


    /**
     * Método para obtener los viajes por destino.
     * @param destino El destino de los viajes a buscar.
     * @return Lista de viajes con el destino especificado.
     */
    // localhost:9001/viaje/destino:Tenerife
    @GetMapping("/destino:{destino}")
    public ArrayList<Viaje> getViajesByDestino(@PathVariable("destino") String destino) {
        return viajeService.getViajesByDestino(destino);
    }


    /**
     * Método para obtener los viajes por procedencia.
     * @param procedencia La procedencia de los viajes a buscar.
     * @return Lista de viajes con la procedencia especificada.
     */
    // localhost:9001/viaje/procedencia?procedencia=Fuerteventura
    @GetMapping("/procedencia")
    public ArrayList<Viaje> getViajesByProcedencia(@RequestParam(name = "procedencia", required = false, defaultValue = "Tenerife") String procedencia) {
        return viajeService.getViajesByProcedencia(procedencia);
    }

    /**
     * Método para buscar viajes en un rango de precios.
     * @param precioMinimo Precio mínimo del rango.
     * @param precioMaximo Precio máximo del rango.
     * @return Lista de viajes en el rango de precios especificado.
     */
    //localhost:9001/viaje/buscarPorRangoPrecio?precioMinimo=70&precioMaximo=100
    @GetMapping("/buscarPorRangoPrecio")
    public ArrayList<Viaje> buscarViajesRangoPorPrecio(
            @RequestParam(name = "precioMinimo", required = true) int precioMinimo,
            @RequestParam(name = "precioMaximo", required = true) int precioMaximo) {
        return viajeService.buscarViajesRangoPorPrecio(precioMinimo, precioMaximo);
    }

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
    /**
     * Método para registrar un nuevo viaje.
     * @param viaje La información del nuevo viaje.
     */
    public void postRegisterViaje(@RequestBody ViajeDTO viaje) {     
        viajeService.postRegisterViaje(viaje);
    }
    

    /**
     * Método para eliminar un viaje.
     * @param id El ID del viaje a eliminar.
     */
    // localhost:9001/viaje/delete:tf02
    @DeleteMapping("/delete:{id}")
    public void deleteViaje(@PathVariable("id") String id){
        viajeService.deleteViaje(id);
    }


    
     // localhost:9001/viaje/nuevodestino:tf02
     /*
      * {
      *  "fecha_llegada": "2023-12-23 12:30:00"
      * }
      *
      */
    @PutMapping("nuevodestino:{id}")
        /**
     * Método para actualizar el destino de un viaje.
     * @param id El ID del viaje a actualizar.
     * @param viaje La nueva información del viaje.
     */
    public void putViajeDestino(@PathVariable String id, @RequestBody ViajeDTO viaje) {
        viajeService.updateViajeDestino(id, viaje);
    }
}
