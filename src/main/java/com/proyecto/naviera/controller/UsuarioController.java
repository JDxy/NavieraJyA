package com.proyecto.naviera.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.naviera.model.Usuario;
import com.proyecto.naviera.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
}
