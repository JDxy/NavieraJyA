package com.proyecto.naviera.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    // localhost:9001/usuario/mail?mail=Canary7IslandAIPonceP@gmail.com
    @GetMapping("/mail")
    public ArrayList<Usuario> getUsuariosBymail(@RequestParam(name = "mail", required = false, defaultValue = "Canary7IslandAIPonceP@gmail.com") String mail) {
        return usuarioService.getUsuariosBymail(mail);
    }   
   
}
