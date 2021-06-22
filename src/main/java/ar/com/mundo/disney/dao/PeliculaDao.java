package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Pelicula;

@Repository
public interface PeliculaDao extends JpaRepository<Pelicula, Long> {

}
