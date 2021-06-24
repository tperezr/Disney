package ar.com.mundo.disney.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mundo.disney.dto.PeliculaDto;
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
	
	@GetMapping("/{id}")
	public Pelicula getPeliculasDetails(@PathVariable Long id){
		Optional<Pelicula> pelicula = peliculaService.buscarPeliculaPorId(id);
		return pelicula.isPresent() ? pelicula.get() : null;
	}
	
	@GetMapping(params = "name")
	public PeliculaDto getPeliculaPorNombre(@RequestParam(value = "name") String titulo) {
		Optional<Pelicula> pelicula = peliculaService.buscarPeliculaPorTitulo(titulo);

		if(pelicula.isPresent()) {
			return createPeliculaDto(pelicula.get());
		}
		
		return null;
	}
	
	@GetMapping(params = "genre")
	public List<PeliculaDto> getPeliculasPorGenero(@RequestParam(value = "genre") Long id){
		return createPeliculasListDto(peliculaService
				.buscarPeliculasPorGenero(new Genero(id)));
	}
	
	@GetMapping(params = "order")
	public List<PeliculaDto> getPeliculasPorFechaOrd(@RequestParam(value = "order")String order){
		Sort.Direction ORDER;
		order = order.toUpperCase();
		
		if(order.equals("ASC")) {
			ORDER = Sort.Direction.ASC;
		} else if(order.equals("DESC")) {
			ORDER = Sort.Direction.DESC;
		} else {
			return null;
		}
		
		return createPeliculasListDto(peliculaService
				.listarPeliculasOrdenadaPorFecha(Sort.by(ORDER,"fechaCreacion")));
	}
	
	private List<PeliculaDto> createPeliculasListDto(List<Pelicula> peliculas){
		List<PeliculaDto> response = peliculas.stream()
				.map(pelicula -> createPeliculaDto(pelicula))
				.collect(Collectors.toList());
		return response;
	}
	
	private PeliculaDto createPeliculaDto(Pelicula pelicula) {
		return new PeliculaDto(
				pelicula.getId(),
				pelicula.getTitulo(),
				pelicula.getFechaCreacion(),
				pelicula.getCalificacion(),
				pelicula.getImagen(),
				pelicula.getGenero().getNombre()
				);
	}
}

