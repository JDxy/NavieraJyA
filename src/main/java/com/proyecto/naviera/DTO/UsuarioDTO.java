package com.proyecto.naviera.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String id;
    private String nombre;
    private String contraseña;
    private String mail;
    private int tlf;
    private boolean pasajero;
    private boolean admin;
}
