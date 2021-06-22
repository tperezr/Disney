package ar.com.mundo.disney.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.dto.PeliculaResponseDto;
import ar.com.mundo.disney.model.Genero;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	@Autowired
	PeliculaService peliculaService;
	
	@GetMapping
	public List<PeliculaResponseDto> getPeliculas(){
		 
		List<PeliculaResponseDto> response = peliculaService.listarPeliculas().stream()
				.map(element -> new PeliculaResponseDto(
						element.getImagen(),
						element.getTitulo(),
						element.getFechaCreacion()
						)).collect(Collectors.toList());
	
		return response;
	}
	
	@GetMapping("/details")
	public List<Pelicula> getPeliculasDetails(){
		return peliculaService.listarPeliculas();
	}
	
	@GetMapping(params = "name")
	public Pelicula getPeliculaPorNombre(@RequestParam(value = "name") String titulo) {
		
		Optional<Pelicula> pelicula = peliculaService.buscarPeliculaPorTitulo(titulo);
		
		return pelicula.isEmpty() ? null : pelicula.get();
	}
	
	@GetMapping(params = "genre")
	public List<Pelicula> getPeliculasPorGenero(@RequestParam(value = "genre") Long id){
		Genero genero = new Genero(id);
		return peliculaService.buscarPeliculasPorGenero(genero);
	}
	
	@GetMapping(params = "order")
	public List<Pelicula> getPeliculasPorFechaOrd(@RequestParam(value = "order")String order){
		Sort.Direction ORDER;
		order = order.toUpperCase();
		
		if(order.equals("ASC")) {
			ORDER = Sort.Direction.ASC;
		} else if(order.equals("DESC")) {
			ORDER = Sort.Direction.DESC;
		} else {
			return null;
		}
		
		return peliculaService.listarPeliculasOrdenadaPorFecha(Sort.by(ORDER,"fechaCreacion"));
	}
} 
