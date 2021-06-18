package ar.com.mundo.disney.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.model.Usuario;

@RestController
@RequestMapping(name = "/auth")
public class UserController {
	
	@PostMapping("/login")
	public String login(Usuario usuario) {
		return "log in successfull";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "it works";
	}
}
