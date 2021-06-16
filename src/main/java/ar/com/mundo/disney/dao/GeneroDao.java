package ar.com.mundo.disney.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.mundo.disney.model.Genero;

public interface GeneroDao extends CrudRepository<Genero, Long> {

}
