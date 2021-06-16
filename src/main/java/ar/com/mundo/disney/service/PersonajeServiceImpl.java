package ar.com.mundo.disney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mundo.disney.dao.PersonajeDao;
import ar.com.mundo.disney.model.Personaje;

@Service
public class PersonajeServiceImpl implements PersonajeService {
	
	@Autowired
	private PersonajeDao personajeDao;
	
	@Override
	public List<Personaje> listarPersonajes() {
		return null;
	}

	@Override
	public void guardar(Personaje personaje) {

	}

	@Override
	public void eliminar(Personaje personaje) {

	}

	@Override
	public Personaje buscarPersonaje(Personaje personaje) {
		return null;
	}

}
