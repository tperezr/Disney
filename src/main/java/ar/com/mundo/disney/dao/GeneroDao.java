package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mundo.disney.model.Genero;

public interface GeneroDao extends JpaRepository<Genero, Long> {

}
