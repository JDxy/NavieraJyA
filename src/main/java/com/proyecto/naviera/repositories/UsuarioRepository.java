package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
      public abstract ArrayList<Usuario> findAll(); 
      public abstract ArrayList<Usuario> findBymail(String mail);  
      public abstract Usuario findUsuarioById(String id);
      public abstract void deleteById(String id);   
      public abstract ArrayList<Usuario> findByPasajero(boolean bool);
}