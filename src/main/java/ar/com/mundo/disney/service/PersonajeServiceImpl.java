package ar.com.mundo.disney.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.mundo.disney.dao.PersonajeDao;
import ar.com.mundo.disney.model.Pelicula;
import ar.com.mundo.disney.model.Personaje;

@Service
public class PersonajeServiceImpl implements PersonajeService {
	
	@Autowired
	private PersonajeDao personajeDao;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional(readOnly = true)
	public List<Personaje> listarPersonajes() {
		return (List<Personaje>) personajeDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Personaje personaje) {
		personajeDao.save(personaje);
	}

	@Override
	@Transactional
	public void eliminar(Personaje personaje) {
		personajeDao.delete(personaje);
	}

	@Override
	@Transactional(readOnly = true)
	public Personaje buscarPersonaje(Long id) {	
		return personajeDao.findById(id).get();
	}

	@Override
	public Personaje buscarPorNombre(String nombre) {
		return personajeDao.findByNombre(nombre);
	}

	@Override
	public List<Personaje> buscarPorEdad(Integer edad) {
		return personajeDao.findByEdad(edad);
	}

	@Override
	public List<Personaje> buscarPorPeso(Integer peso) {
		return personajeDao.findByPeso(peso);
	}
	/*
	@Override
	public List<Personaje> buscarPorPeliculas(List<Pelicula> peliculas) {
		return personajeDao.findByPeliculas(peliculas);
	}
	*/
	

}
