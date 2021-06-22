package ar.com.mundo.disney.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	public List<PersonajeResponseDto> getPersonajes(){
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
	public Personaje getPersonajePorNombre(@RequestParam(value = "name") String nombre) {
		Optional<Personaje> personaje = personajeService.buscarPorNombre(nombre);

		return personaje.isEmpty() ? null : personaje.get();
	}
	
	@GetMapping(params = "age")
	public List<Personaje> getPersonajesPorEdad(@RequestParam(value = "age") Integer edad) {	
		return personajeService.buscarPorEdad(edad);
	}
	
	@GetMapping(params = "weight")
	public List<Personaje> getPersonajesPorPeso(@RequestParam(value = "weight") Integer peso) {
		return personajeService.buscarPorPeso(peso);
	}
	
	@GetMapping(params = "movies")
	public List<PersonajeDto> getPersonajesPorPeliculas(@RequestParam(value = "movies") Long idMovie) {
		List<Pelicula> peliculas = List.of(new Pelicula(idMovie));
		List<PersonajeDto> response = personajeService.buscarPorPeliculas(peliculas).stream()
				.map(personaje -> new PersonajeDto(
						personaje.getId(),
						personaje.getNombre(),
						personaje.getEdad(),
						personaje.getPeso(),
						personaje.getHistoria(),
						personaje.getImagen()
						)).collect(Collectors.toList());
		return response; 
	}
}
