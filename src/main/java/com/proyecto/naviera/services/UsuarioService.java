package com.proyecto.naviera.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.naviera.DTO.UsuarioDTO;
import com.proyecto.naviera.DTO.ViajeDTO;
import com.proyecto.naviera.model.Usuario;
import com.proyecto.naviera.model.Viaje;
import com.proyecto.naviera.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired //-> es la inyeccion de dependencias
    private UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> getAllUsuarios() {
      return usuarioRepository.findAll();
    }

    public ArrayList<Usuario> getUsuariosBymail(String mail) {
      return usuarioRepository.findBymail(mail); 
    }  

    public void deleteUsuario(String id){
      usuarioRepository.deleteById(id);
    }

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

    public void updateUsuarioNombre(String id, UsuarioDTO usuarioDTO) {
      Usuario usuario=usuarioRepository.findUsuarioById(id);
      if(usuario!=null){
        usuario.setNombre(usuarioDTO.getNombre());
        usuarioRepository.save(usuario);
      }     
    }

    public ArrayList<Usuario> getUsuariosPasajeros() {
      return usuarioRepository.findByPasajero(true);
  }
  
}
