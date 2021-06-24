package ar.com.mundo.disney.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.mundo.disney.dao.UsuarioDao;
import ar.com.mundo.disney.model.RequestRegister;
import ar.com.mundo.disney.model.Rol;
import ar.com.mundo.disney.model.Usuario;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioDao.findByUsername(username);
		
		
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		for (Rol rol : usuario.get().getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		
		return new User(usuario.get().getUsername(), usuario.get().getPassword(), roles);
	}
	
	public Boolean registrarUsuario(RequestRegister requestRegister) {
		
		boolean existeUsername = usuarioDao.findByUsername(requestRegister.getUsername()).isPresent();
		boolean existeEmail = usuarioDao.findByEmail(requestRegister.getEmail()).isPresent();
		Usuario usuario;
		
		if(!existeEmail && !existeUsername) {
			usuario = new Usuario();
			usuario.setEmail(requestRegister.getEmail());
			usuario.setUsername(requestRegister.getUsername());
			usuario.setPassword(bCryptPasswordEncoder.encode(requestRegister.getPassword()));
			usuario.setRoles(List.of(new Rol(null,"ROLE_USER")));
			
			usuarioDao.save(usuario);
		} else {
			return false;
		}
		
		return true;
	}
}
