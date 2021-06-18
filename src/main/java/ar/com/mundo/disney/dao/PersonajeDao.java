package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mundo.disney.model.Personaje;

public interface PersonajeDao extends JpaRepository<Personaje, Long> {
	
}
