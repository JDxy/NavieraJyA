package com.proyecto.naviera.model;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "usuarios")
public class Usuario {
    private String id;
    private String nombre;
    private String contraseña;
    private String mail;
    private int tlf;
    private boolean pasajero;
    private boolean admin;
}
