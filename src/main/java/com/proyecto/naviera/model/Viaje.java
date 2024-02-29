package com.proyecto.naviera.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Viajes")
public class Viaje {
   private String id;
   private int precio;
   private String fecha_Salida;
   private String fecha_Llegada;
   private String destino;
   private String procedencia;
   private int plazas_Turista;
   private int plazas_Primera;
}
