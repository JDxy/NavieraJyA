package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.naviera.DTO.UsuarioDTO;
import com.proyecto.naviera.model.Usuario;
import com.proyecto.naviera.repositories.UsuarioRepository;

/**
 * Servicio para manejar operaciones relacionadas con usuarios.
 */
@Service
public class UsuarioService {
    @Autowired //-> es la inyeccion de dependencias
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene todos los usuarios registrados en el sistema.
     * 
     * @return Lista de todos los usuarios.
     */
    public ArrayList<Usuario> getAllUsuarios() {
      return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario por su dirección de correo electrónico.
     * 
     * @param mail La dirección de correo electrónico del usuario a buscar.
     * @return Lista de usuarios que coinciden con la dirección de correo electrónico especificada.
     */
    public ArrayList<Usuario> getUsuariosBymail(String mail) {
      return usuarioRepository.findBymail(mail); 
    }  

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id El ID del usuario a eliminar.
     */
    public void deleteUsuario(String id){
      usuarioRepository.deleteById(id);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param usuarioDTO Los datos del nuevo usuario a registrar.
     */
    public void postRegisterUsuario(UsuarioDTO usuarioDTO) {
      Usuario usuario = new Usuario();
      if (usuarioDTO.getNombre() != null && usuarioDTO.getContraseña() != null) {
          usuario.setId(usuarioDTO.getId());
          usuario.setNombre(usuarioDTO.getNombre());
          usuario.setContraseña(usuarioDTO.getContraseña());
          usuario.setMail(usuarioDTO.getMail());
          usuario.setTlf(usuarioDTO.getTlf());
          usuario.setPasajero(usuarioDTO.isPasajero());
          usuario.setAdmin(usuarioDTO.isAdmin());
          usuarioRepository.save(usuario);
      }
    }

    /**
     * Actualiza el nombre de un usuario por su ID.
     * 
     * @param id El ID del usuario cuyo nombre se actualizará.
     * @param usuarioDTO Los nuevos datos del usuario, incluido el nombre actualizado.
     */
    public void updateUsuarioNombre(String id, UsuarioDTO usuarioDTO) {
      Usuario usuario=usuarioRepository.findUsuarioById(id);
      if(usuario!=null){
        usuario.setNombre(usuarioDTO.getNombre());
        usuarioRepository.save(usuario);
      }     
    }
    
    /**
     * Obtiene todos los usuarios que son pasajeros registrados en el sistema.
     * 
     * @return Lista de usuarios que son pasajeros.
     */
    public ArrayList<Usuario> getUsuariosPasajeros() {
      return usuarioRepository.findByPasajero(true);
  }
  
}
