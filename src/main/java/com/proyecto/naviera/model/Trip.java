package com.proyecto.naviera.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

// se añade @Data para q con el lombox se generen 
// solos los constructores y gettes y setters
@Data 
@Document(collection = "trips")
public class Trip {
    private String id;
    private String nombre;
    private String origen;
    private String destino;
    private int duracion;
    private int escala;   
    private double precio;
}