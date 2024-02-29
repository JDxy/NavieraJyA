package com.proyecto.naviera.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
