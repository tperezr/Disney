package ar.com.mundo.disney.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Personaje;

@Repository
public interface PersonajeDao extends JpaRepository<Personaje, Long> {
	
	Personaje findByNombre(String nombre);
	
	List<Personaje> findByEdad(Integer edad);
	
	List<Personaje> findByPeso(Integer peso);
	/*
	@Query("select p.id,p.edad,p.historia,p.imagen,p.nombre,p.peso from Personaje p"
			+ " inner join pelicula_personaje p_p on p.id = p_p.id_personaje"
			+ " where p_p.id_pelicula = :idMovie")*/
	
	@Query("SELECT p FROM Personaje p"
			+ " JOIN FETCH p.peliculas"
			+ " WHERE p.id = :idMovie")
	List<Personaje> findByPeliculas(@Param("idMovie") Long id);
}
