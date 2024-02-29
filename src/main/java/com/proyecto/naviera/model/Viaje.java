package com.proyecto.naviera.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "viajes")
public class Viaje {
   private String id;
   private int precio;
   private String fecha_salida;
   private String fecha_llegada;
   private String destino;
   private String procedencia;
   private int plazas_turista;
   private int plazas_primera;
}
