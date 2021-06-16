package ar.com.mundo.disney.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.mundo.disney.model.Pelicula;

public interface PeliculaDao extends CrudRepository<Pelicula, Long> {

}
