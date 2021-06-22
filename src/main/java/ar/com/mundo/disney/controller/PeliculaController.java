package ar.com.mundo.disney.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.dto.PeliculaResponseDto;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	PeliculaService pelicuaService;
	
	@GetMapping
	public List<PeliculaResponseDto> getPeliculas(){
		 
		List<PeliculaResponseDto> response = pelicuaService.listarPeliculas().stream()
				.map(element -> new PeliculaResponseDto(
						element.getImagen(),
						element.getTitulo(),
						element.getFechaCreacion()
						)).collect(Collectors.toList());
	
		return response;
	}
	
	@GetMapping(path = "/{id}")
	public Pelicula getPeliculaPorId(@PathVariable Long id) {
		return pelicuaService.buscarPeliculaPorId(id);
	}
	
}
