package ar.com.mundo.disney.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Genero;
import ar.com.mundo.disney.model.Pelicula;

@Repository
public interface PeliculaDao extends JpaRepository<Pelicula, Long> {
	Optional<Pelicula> findByTitulo(String titulo);
	
	List<Pelicula> findByGenero(Genero genero);
}
