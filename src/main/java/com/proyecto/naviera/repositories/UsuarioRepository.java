package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.naviera.model.Usuario;

/**
 * Repositorio para operaciones de base de datos relacionadas con los usuarios.
 */
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
      
      /**
       * Obtiene todos los usuarios registrados en la base de datos.
       * 
       * @return Lista de todos los usuarios.
       */
      public abstract ArrayList<Usuario> findAll(); 
      
      /**
       * Busca usuarios por su dirección de correo electrónico.
       * 
       * @param mail La dirección de correo electrónico del usuario.
       * @return Lista de usuarios que coinciden con la dirección de correo electrónico especificada.
       */
      public abstract ArrayList<Usuario> findBymail(String mail);  
      
      /**
       * Busca un usuario por su ID.
       * 
       * @param id El ID del usuario.
       * @return El usuario encontrado o null si no se encuentra ningún usuario con el ID especificado.
       */
      public abstract Usuario findUsuarioById(String id);
      
      /**
       * Elimina un usuario por su ID.
       * 
       * @param id El ID del usuario a eliminar.
       */
      public abstract void deleteById(String id);   
      
      /**
       * Busca usuarios que sean pasajeros.
       * 
       * @param bool Booleano que indica si el usuario es pasajero o no.
       * @return Lista de usuarios que son pasajeros si bool es true, de lo contrario, una lista vacía.
       */
      public abstract ArrayList<Usuario> findByPasajero(boolean bool);
}