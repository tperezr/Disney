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
import ar.com.mundo.disney.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	PeliculaService pelicuaService;
	
	@GetMapping()
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
	
	@GetMapping("/{id}")
	public Pelicula getPeliculaPorId(@PathVariable Long id) {
		return pelicuaService.buscarPeliculaPorId(id);
	}
	
}
