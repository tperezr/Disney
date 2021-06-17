package ar.com.mundo.disney.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.mundo.disney.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}
