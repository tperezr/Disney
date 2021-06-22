package ar.com.mundo.disney.service;

import java.util.List;

import ar.com.mundo.disney.dto.PersonajeDto;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;

public interface PersonajeService {

    public List<Personaje> listarPersonajes();
    
    public void guardar(Personaje personaje);
    
    public void eliminar(Personaje personaje);
    
    public Personaje buscarPersonaje(Long id);
    
    public Personaje buscarPorNombre(String nombre);
	
   	public List<Personaje> buscarPorEdad(Integer edad);
   	
   	public List<Personaje> buscarPorPeso(Integer peso);
   	
   	//public List<Personaje> buscarPorPeliculas(List<Pelicula> peliculas);
}
