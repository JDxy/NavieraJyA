package com.proyecto.naviera.DTO;

import lombok.Data;

@Data
public class ViajeDTO {
    private int Precio;
    private String Fecha_Salida;
    private String Fecha_Llegada;
    private String Destino;
    private String Procedencia;
    private int Plazas_Turista;
    private int Plazas_Primera;
}
