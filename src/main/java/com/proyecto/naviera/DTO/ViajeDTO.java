package com.proyecto.naviera.DTO;

import lombok.Data;

@Data
public class ViajeDTO {
    private int precio;
    private String fecha_Salida;
    private String fecha_Llegada;
    private String destino;
    private String procedencia;
    private int plazas_Turista;
    private int plazas_Primera;
}
