package com.proyecto.naviera.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import com.proyecto.naviera.model.BilletesComprados;

@Repository
public class BilletesCompradosRepositoryCustom implements BilletesCompradosRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    /**
     *  Método para encontrar los viajes asociados a una fecha específica en los billetes comprados
     *  Se devuelve la lista de viajes encontrados
    */
    @Override
    public ArrayList<String> findViajesByFecha(String fecha) {
        // Se crea una consulta MongoDB para encontrar documentos donde el campo "fecha" coincida con el valor proporcionado
        Query query = new Query(Criteria.where("fecha").is(fecha));
        // Se ejecuta la consulta en la base de datos MongoDB utilizando el mongoTemplate,
        // luego se mapean los resultados para obtener solo los viajes y se los convierte en un flujo de datos
        ArrayList<String> viajes = (ArrayList<String>) mongoTemplate.find(query, BilletesComprados.class)
                                            .stream().map(BilletesComprados::getViajes)
                                            .flatMap(ArrayList::stream)
                                            .collect(Collectors.toList());       
        return viajes;
    }

    /**
     * Método para eliminar los billetes comprados asociados a una fecha específica de la base de datos.     * 
     * @param fecha La fecha específica para la cual se eliminarán los billetes comprados.
     */
    @Override
    public void deleteByFecha(String fecha) {
        // Se utiliza mongoTemplate para eliminar documentos de la colección "BilletesComprados"
        // donde el campo "fecha" coincide con el valor proporcionado.
        mongoTemplate.remove(new Query(Criteria.where("fecha").is(fecha)), BilletesComprados.class);
    }

    @Override
    public <S extends BilletesComprados> S insert(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public <S extends BilletesComprados> List<S> insert(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public <S extends BilletesComprados> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends BilletesComprados> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends BilletesComprados> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public List<BilletesComprados> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<BilletesComprados> findAllById(Iterable<String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends BilletesComprados> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<BilletesComprados> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void delete(BilletesComprados entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteAll(Iterable<? extends BilletesComprados> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public List<BilletesComprados> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<BilletesComprados> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends BilletesComprados> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public <S extends BilletesComprados> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends BilletesComprados> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends BilletesComprados> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends BilletesComprados, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    // Puedes implementar otros métodos de consulta personalizados aquí
}
