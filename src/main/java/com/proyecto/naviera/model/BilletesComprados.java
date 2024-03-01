package com.proyecto.naviera.model;

import java.util.ArrayList;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "billetesComprados")
public class BilletesComprados {
    private String fecha;
    private ArrayList viajes;
    private ArrayList pasajeros;    
}
