package ar.com.mundo.disney.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mundo.disney.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
}
