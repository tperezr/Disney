package ar.com.mundo.disney.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.model.JwtRequestLogin;
import ar.com.mundo.disney.model.RequestRegister;
import ar.com.mundo.disney.service.UsuarioService;
import ar.com.mundo.disney.util.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	//SengridMailSender sengridMailSender = new SengridMailSender();
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody JwtRequestLogin usuario) {
		try {
			authenticate(usuario.getUsername(),usuario.getPassword());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
		
		final UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getUsername());
		
		final String token = jwtTokenUtil.getToken(userDetails);
		
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody RequestRegister usuario) {
		if(usuarioService.registrarUsuario(usuario)) {
			
			return ResponseEntity.ok("Registro exitoso");
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario ya existente");
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Credenciales invalidas", e);
		}
	}
}
