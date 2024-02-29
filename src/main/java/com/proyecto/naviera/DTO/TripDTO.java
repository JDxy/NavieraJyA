package com.proyecto.naviera.DTO;

import lombok.Data;

@Data 
public class TripDTO {    
    private String nombre;
    private String origen;
    private String destino;
    private int duracion;
    private int escala;   
    private double precio;
}
