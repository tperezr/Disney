package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mundo.disney.model.Pelicula;

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {

}
