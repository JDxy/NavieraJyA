package com.proyecto.naviera.DTO;

import lombok.Data;

@Data
public class ViajeDTO {
    private String id;
    private int precio;
    private String fecha_salida;
    private String fecha_llegada;
    private String destino;
    private String procedencia;
    private int plazas_turista;
    private int plazas_primera;
}
