package ar.com.mundo.disney.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;

@Repository
public interface PersonajeDao extends JpaRepository<Personaje, Long> {
	
	Optional<Personaje> findByNombre(String nombre);
	
	List<Personaje> findByEdad(Integer edad);
	
	List<Personaje> findByPeso(Integer peso);
	
	List<Personaje> findByPeliculasIn(List<Pelicula> peliculas);
}
