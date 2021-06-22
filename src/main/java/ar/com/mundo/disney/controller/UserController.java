package ar.com.mundo.disney.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.model.Usuario;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario) {
		return "Log in successfull";
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(Usuario usuario) {
		return ResponseEntity.accepted().body("Registro exitoso");
	}
}
