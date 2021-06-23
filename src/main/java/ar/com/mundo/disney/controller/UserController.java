package ar.com.mundo.disney.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.model.JwtRequest;
import ar.com.mundo.disney.model.Usuario;
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
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody JwtRequest usuario) throws Exception {
		
		authenticate(usuario.getUsername(),usuario.getPassword());
		
		final UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Usuario usuario) {
		return ResponseEntity.accepted().body("Registro exitoso");
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Credenciales invalidas", e);
		}
	}
	
	
	 /* return ResponseEntity.accepted().body(getJWTToken(usuario.getUsername()));
	try {

	    Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(compactJws);

	    //OK, we can trust this JWT

	} catch (JwtException e) {

	    //don't trust the JWT!
	}*/
	
}
