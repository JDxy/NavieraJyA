package com.proyecto.naviera.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.naviera.model.BilletesComprados;
import com.proyecto.naviera.services.BilletesCompradosService;

@RestController
@RequestMapping("/billetesComprados")
public class BilletesCompradosController {
    @Autowired
    private BilletesCompradosService billetesCompradosService;

    @GetMapping()
    public ArrayList<BilletesComprados> getAllBilletesComprados() {
        return billetesCompradosService.getAllBilletesComprados();
    }
    
    // localhost:9001/billetesComprados/buscar?fecha=2023-12-19 08:30:00
    @GetMapping("/buscar")
    public ArrayList<String> findViajesByFecha(@RequestParam String fecha) {
        return billetesCompradosService.findViajesByFecha(fecha);
    }
    
}
