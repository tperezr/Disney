package ar.com.mundo.disney.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public Personaje getPersonajePorId(@PathVariable Long id) {
		Optional<Personaje> personaje = personajeService.buscarPersonaje(id);
		
		return personaje.isPresent() ? personaje.get() : null;
	}
	
	@GetMapping(params = "name")
	public PersonajeDto getPersonajePorNombre(@RequestParam(value = "name") String nombre) {
		Optional<Personaje> personaje = personajeService.buscarPorNombre(nombre);
		
		if(personaje.isEmpty()) {
			return null;
		}
		
		return createPersonajeDto(personaje.get());
	}
	
	@GetMapping(params = "age")
	public List<PersonajeDto> getPersonajesPorEdad(@RequestParam(value = "age") Integer edad) {	
		return createPersonajesListDto(personajeService.buscarPorEdad(edad));
	}
	
	@GetMapping(params = "weight")
	public List<PersonajeDto> getPersonajesPorPeso(@RequestParam(value = "weight") Integer peso) {
		return createPersonajesListDto(personajeService.buscarPorPeso(peso));
	}
	
	@GetMapping(params = "movies")
	public List<PersonajeDto> getPersonajesPorPeliculas(@RequestParam(value = "movies") Long idMovie) {
		return createPersonajesListDto(personajeService.buscarPorPeliculas(List.of(new Pelicula(idMovie)))); 
	}
	
	private List<PersonajeDto> createPersonajesListDto(List<Personaje> personajes){
		List<PersonajeDto> response = personajes.stream()
				.map(personaje -> createPersonajeDto(personaje)).collect(Collectors.toList());
		return response;
	}
	
	private PersonajeDto createPersonajeDto(Personaje personaje) {
		return new PersonajeDto(
				personaje.getId(),
				personaje.getNombre(),
				personaje.getEdad(),
				personaje.getPeso(),
				personaje.getHistoria(),
				personaje.getImagen()
				);
	}
}
