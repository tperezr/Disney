package ar.com.mundo.disney.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.dto.PeliculaResponseDto;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;
import ar.com.mundo.disney.service.PeliculaService;
import ar.com.mundo.disney.service.PersonajeService;

@RestController
@RequestMapping(name = "/")
public class DisneyController {
	
	@Autowired
	PersonajeService personajeService;
	
	@Autowired
	PeliculaService pelicuaService;
	
	@GetMapping("/characters")
	public List<Personaje> getPersonajes(){	
		return personajeService.listarPersonajes();
	}
	
	@GetMapping("/movies")
	public List<PeliculaResponseDto> getPeliculas(){
		List<Pelicula> peliculas = pelicuaService.listarPeliculas();
		List<PeliculaResponseDto> response = new ArrayList<PeliculaResponseDto>();
		
		for (Pelicula pelicula : peliculas) {
			response.add(new PeliculaResponseDto(
					pelicula.getImagen(),
					pelicula.getTitulo(),
					pelicula.getFechaCreacion()
					));
		}
	
		return response;
	}
	
	@GetMapping("/movies/{id}")
	public Pelicula getPeliculaDetalle(@PathVariable Long id) {
		return pelicuaService.buscarPeliculaPorId(id);
	}
}
