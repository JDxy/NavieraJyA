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

/**
 * Controlador para manejar las solicitudes relacionadas con los usuarios.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtiene todos los usuarios.
     * 
     * @return Lista de todos los usuarios.
     * 
     * Ejemplo de ejecucion:
     * GET localhost:9001/usuario
     */
    @GetMapping()
    public ArrayList<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    /**
     * Obtiene usuarios por correo electrónico.
     * 
     * @param mail El correo electrónico del usuario a buscar.
     * @return Lista de usuarios con el correo electrónico especificado.
     * 
     * Ejemplo de ejecución:
     * GET localhost:9001/usuario/mail?mail=Canary7IslandAIPonceP@gmail.com
     */
     @GetMapping("/mail")
    public ArrayList<Usuario> getUsuariosBymail(@RequestParam(name = "mail", required = false, defaultValue = "Canary7IslandAIPonceP@gmail.com") String mail) {
        return usuarioService.getUsuariosBymail(mail);
    }  

        
    /**
     * Agrega un nuevo usuario al sistema.
     * 
     * @param id El ID único del nuevo usuario.
     * @param usuario Los datos del nuevo usuario a agregar.
     * 
     * Ejemplo de ejecución: 
     * POST localhost:9001/usuario/addusuario:usuario04
     * {
     *     "id": "usuario04",
     *     "nombre": "Pepe",
     *     "contraseña": "123",
     *     "mail": "pepe@gmail.com",
     *     "tlf": 928488921,
     *     "pasajero": false,
     *     "admin": false
     * }
     */  
    @PostMapping("addusuario:{id}")
    public void postRegisterUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuario) {
        usuarioService.postRegisterUsuario(usuario);
    }

    /**
     * Elimina un usuario del sistema por su ID.
     * 
     * @param id El ID del usuario a eliminar.
     * 
     * Ejemplo de ejecución: 
     * DELETE localhost:9001/usuario/delete:usuario04
     */
    @DeleteMapping("/delete:{id}")
    public void deleteUsuario(@PathVariable("id") String id){
        usuarioService.deleteUsuario(id);
    }

    /**
     * Actualiza el nombre de un usuario existente en el sistema.
     * 
     * @param id El ID del usuario cuyo nombre se actualizará.
     * @param usuario Los nuevos datos del usuario, incluido el nombre actualizado.
     * 
     * Ejemplo de ejecución:
     * PUT localhost:9001/usuario/nuevonombre:usuario04
     * {
     *     "nombre": "Pepo"
     * }
     */
    @PutMapping("/nuevonombre:{id}")
    public void putUsuarioNombre(@PathVariable String id, @RequestBody UsuarioDTO usuario) {
        usuarioService.updateUsuarioNombre(id, usuario);
    }

    /**
     * Obtiene todos los usuarios que son pasajeros registrados en el sistema.
     * 
     * @return Lista de usuarios que son pasajeros.
     * 
     * Ejemplo de ejecución: 
     * GET localhost:9001/usuario/pasajeros
     */
    @GetMapping("/pasajeros")
    public ArrayList<Usuario> getUsuariosPasajeros() {
        return usuarioService.getUsuariosPasajeros();
    }
    
}
