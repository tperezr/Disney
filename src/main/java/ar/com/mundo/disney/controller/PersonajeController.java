package ar.com.mundo.disney.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.dto.PeliculaResponseDto;
import ar.com.mundo.disney.dto.PersonajeResponseDto;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;
import ar.com.mundo.disney.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	PersonajeService personajeService;
	
	@GetMapping
	public List<PersonajeResponseDto> getPersonajes(){	
		List<Personaje> personajes = personajeService.listarPersonajes();
		List<PersonajeResponseDto> response = new ArrayList<PersonajeResponseDto>();
		
		for (Personaje personaje : personajes) {
			response.add(new PersonajeResponseDto(
					personaje.getNombre(),
					personaje.getImagen()
					));
		}
	
		return response;
	}
	
	@GetMapping("/{id}")
	public Personaje getPersonajePorId(@PathVariable Long id) {
		return personajeService.buscarPersonaje(id);
	}
	/*
	@GetMapping
	public Personaje getPersonajePorNombre(@PathParam(value = "name") String nombre) {
		return personajeService.buscarPorNombre(nombre);
	}
	
	@GetMapping
	public List<Personaje> getPersonajePorEdad(@PathParam(value = "age") Integer edad) {
		return personajeService.buscarPorEdad(edad);
	}
	
	@GetMapping
	public Personaje getPersonajePorPelicula(@PathParam(value = "movies") Long id) {
		return null;
	}
	
	@GetMapping
	public List<Personaje> getPersonajePorPeso(@PathParam(value = "weight") Integer peso){
		return personajeService.buscarPorPeso(peso);
	}
	*/
}
