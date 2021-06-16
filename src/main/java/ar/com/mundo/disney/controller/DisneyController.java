package ar.com.mundo.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.model.Personaje;
import ar.com.mundo.disney.service.PersonajeService;

@RestController
public class DisneyController {
	
	@Autowired
	PersonajeService personajeService;
	
	@GetMapping("/characters")
	public List<Personaje> getPersonajes(){	
		return personajeService.listarPersonajes();
	}
}
