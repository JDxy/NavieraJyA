package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
      public abstract ArrayList<Usuario> findAll(); 
      public abstract ArrayList<Usuario> findBymail(String mail);      
}