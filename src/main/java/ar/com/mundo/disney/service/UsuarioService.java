package ar.com.mundo.disney.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.mundo.disney.dao.UsuarioDao;
import ar.com.mundo.disney.model.RequestRegister;
//import ar.com.mundo.disney.model.Rol;
import ar.com.mundo.disney.model.Usuario;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioDao.findByUsername(username);
		
		
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(usuario.get().getUsername(), usuario.get().getPassword(), new ArrayList<GrantedAuthority>());
	}
	
	@Transactional
	public Boolean registrarUsuario(RequestRegister requestRegister) {
		
		boolean existeUsername = usuarioDao.findByUsername(requestRegister.getUsername()).isPresent();
		boolean existeEmail = usuarioDao.findByEmail(requestRegister.getEmail()).isPresent();
		Usuario usuario;
		
		if(!existeEmail && !existeUsername) {
			usuario = new Usuario(null,
					requestRegister.getUsername(),
					passwordEncoder.encode(requestRegister.getPassword()),
					requestRegister.getEmail());
			usuarioDao.save(usuario);
		} else {
			return false;
		}
		
		return true;
	}
}
