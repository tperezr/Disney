package ar.com.mundo.disney.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

import ar.com.mundo.disney.dto.PersonajeDto;
import ar.com.mundo.disney.dto.PersonajeResponseDto;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;
import ar.com.mundo.disney.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	PersonajeService personajeService;
	
	@GetMapping("/test/{id}")
	public List<Personaje> getTest(@PathVariable Long id) {
		return personajeService.buscarPorPeliculas(id);
	}
	
	@GetMapping
	public List<PersonajeResponseDto> getPersonajess(){
		List<PersonajeResponseDto> response = new ArrayList<PersonajeResponseDto>();
		
		response = personajeService.listarPersonajes().stream()
				.map(element -> new PersonajeResponseDto(
						element.getNombre(),
						element.getImagen())
					)
				.collect(Collectors.toList());		
	
		return response;
	}
	
	@GetMapping(params = "name")
	public PersonajeDto getPersonajePorNombre(@RequestParam(value = "name", required = false) String nombre) {
		Personaje personaje;
		PersonajeDto response = null;
		if(nombre != null && !nombre.isEmpty()) {
			personaje = personajeService.buscarPorNombre(nombre);
			response = new PersonajeDto(
					personaje.getIdPersonaje(),
					personaje.getNombre(),
					personaje.getEdad(),
					personaje.getPeso(),
					personaje.getHistoria(),
					personaje.getImagen(),
					personaje.getPeliculas().stream()
					.map(element -> new String(
							element.getTitulo()
							)).collect(Collectors.toList())
					);
		}
		
		return response;
	}
	
	@GetMapping(params = "age")
	public List<PersonajeDto> getPersonajesPorEdad(@RequestParam(value = "age", required = false) Integer edad) {
		List<PersonajeDto> response = null;
		if(edad > 0) {
			response = personajeService.buscarPorEdad(edad).stream()
						.map(element -> new PersonajeDto(
								element.getIdPersonaje(),
								element.getNombre(),
								element.getEdad(),
								element.getPeso(),
								element.getHistoria(),
								element.getImagen(),
								element.getPeliculas().stream()
						.map(pelicula -> new String(
								pelicula.getTitulo()
							)).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		return response;
	}
	
	@GetMapping(params = "weight")
	public List<PersonajeDto> getPersonajesPorPeso(@RequestParam(value = "weight", required = false) Integer peso) {
		List<PersonajeDto> response = null;
		if(peso > 0) {
			response = personajeService.buscarPorPeso(peso).stream()
						.map(element -> new PersonajeDto(
								element.getIdPersonaje(),
								element.getNombre(),
								element.getEdad(),
								element.getPeso(),
								element.getHistoria(),
								element.getImagen(),
								element.getPeliculas().stream()
						.map(pelicula -> new String(
								pelicula.getTitulo()
							)).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		return response;
	}
	/*
	@GetMapping(params = "movies")
	public List<PersonajeDto> getPersonajesPorPeliculas(@RequestParam(value = "movies", required = false) Long idMovie) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.add(new Pelicula(idMovie));
		List<PersonajeDto> response = null;
		if(idMovie > 0) {
			response = personajeService.buscarPorPeliculas(peliculas).stream()
						.map(element -> new PersonajeDto(
								element.getIdPersonaje(),
								element.getNombre(),
								element.getEdad(),
								element.getPeso(),
								element.getHistoria(),
								element.getImagen(),
								element.getPeliculas().stream()
						.map(pelicula -> new String(
								pelicula.getTitulo()
							)).collect(Collectors.toList())
					)).collect(Collectors.toList());
		}
		
		return response;
	}
	*/
	@GetMapping("/{id}")
	public PersonajeDto getPersonajePorId(@PathVariable Long id) {	
		Personaje personaje;
		PersonajeDto response = null;
		if(id > 0) {
			personaje = personajeService.buscarPersonaje(id);
			response = new PersonajeDto(
					personaje.getIdPersonaje(),
					personaje.getNombre(),
					personaje.getEdad(),
					personaje.getPeso(),
					personaje.getHistoria(),
					personaje.getImagen(),
					personaje.getPeliculas().stream()
						.map(element -> new String(
								element.getTitulo()
								)).collect(Collectors.toList())
					);
		}		
		
		return response;
	}
}
