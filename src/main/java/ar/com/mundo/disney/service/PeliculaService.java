package ar.com.mundo.disney.service;

import java.util.List;

import ar.com.mundo.disney.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> listarPeliculas();
    
    public void guardar(Pelicula pelicula);
    
    public void eliminar(Pelicula pelicula);
    
    public Pelicula buscarPeliculaPorId(Long id);
}
