package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Genero;

@Repository
public interface GeneroDao extends JpaRepository<Genero, Long> {

}
