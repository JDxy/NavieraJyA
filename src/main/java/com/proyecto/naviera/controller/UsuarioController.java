package com.proyecto.naviera.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.naviera.DTO.UsuarioDTO;
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


    
    /* 
    localhost:9001/usuario/addusuario:usuario04
    {
        "id": "usuario04",
        "nombre": "Pepe",
        "contraseña": "123",
        "mail": "pepe@gmail.com",
        "tlf": 928488921,
        "pasajero": false,
        "admin": false
    }
    */  
    @PostMapping("addusuario:{id}")
    public void postRegisterUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuario) {
        usuarioService.postRegisterUsuario(usuario);
    }

    // localhost:9001/usuario/delete:usuario04
    @DeleteMapping("/delete:{id}")
    public void deleteUsuario(@PathVariable("id") String id){
        usuarioService.deleteUsuario(id);
    }

    /*
     *     localhost:9001/usuario/nuevonombre:usuario04
     *          {
     *           "nombre": "Pepo"
     *          }
     */
    @PutMapping("/nuevonombre:{id}")
    public void putUsuarioNombre(@PathVariable String id, @RequestBody UsuarioDTO usuario) {
        usuarioService.updateUsuarioNombre(id, usuario);
    }

    @GetMapping("/pasajeros")
    public ArrayList<Usuario> getUsuariosPasajeros() {
        return usuarioService.getUsuariosPasajeros();
    }
    
}
