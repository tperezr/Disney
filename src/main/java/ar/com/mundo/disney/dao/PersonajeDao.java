package ar.com.mundo.disney.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mundo.disney.model.Personaje;

public interface PersonajeDao extends JpaRepository<Personaje, Long> {
	
	Personaje findByNombre(String nombre);
	
	List<Personaje> findByEdad(Integer edad);
	
	List<Personaje> findByPeso(Integer peso);
}
