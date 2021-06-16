package ar.com.mundo.disney.service;

import java.util.List;

import ar.com.mundo.disney.model.Personaje;

public interface PersonajeService {

    public List<Personaje> listarPersonajes();
    
    public void guardar(Personaje personaje);
    
    public void eliminar(Personaje personaje);
    
    public Personaje buscarPersonaje(Personaje personaje);
}
