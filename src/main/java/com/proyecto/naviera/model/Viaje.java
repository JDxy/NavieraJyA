package com.proyecto.naviera.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Viajes")
public class Viaje {
   private String id;
   private int Precio;
   private String Fecha_Salida;
   private String Fecha_Llegada;
   private String Destino;
   private String Procedencia;
   private int Plazas_Turista;
   private int Plazas_Primera;
}
