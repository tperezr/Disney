package ar.com.mundo.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import ar.com.mundo.disney.model.Genero;
import ar.com.mundo.disney.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> listarPeliculas();
    
    public void guardar(Pelicula pelicula);
    
    public void eliminar(Pelicula pelicula);
    
    public Optional<Pelicula> buscarPeliculaPorId(Long id);
    
    public Optional<Pelicula> buscarPeliculaPorTitulo(String titulo);
    
    public List<Pelicula> listarPeliculasOrdenadaPorFecha(Sort sort);
    
    public List<Pelicula> buscarPeliculasPorGenero(Genero genero);

}
