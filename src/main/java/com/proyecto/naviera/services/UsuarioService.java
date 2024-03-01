package com.proyecto.naviera.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.naviera.model.Usuario;
import com.proyecto.naviera.repositories.UsuarioRepository;



@Service
public class UsuarioService {
    @Autowired //-> es la inyeccion de dependencias
    private UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> getAllUsuarios() {
      return usuarioRepository.findAll();
    }
}
