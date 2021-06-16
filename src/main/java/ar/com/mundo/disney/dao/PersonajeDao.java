package ar.com.mundo.disney.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.mundo.disney.model.Personaje;

public interface PersonajeDao extends CrudRepository<Personaje, Long> {
	
}
