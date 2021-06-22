package ar.com.mundo.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import ar.com.mundo.disney.dao.PeliculaDao;
import ar.com.mundo.disney.model.Genero;
import ar.com.mundo.disney.model.Pelicula;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	@Autowired
	PeliculaDao peliculaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> listarPeliculas() {
		return (List<Pelicula>) peliculaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}

	@Override
	@Transactional
	public void eliminar(Pelicula pelicula) {
		peliculaDao.deleteById(pelicula.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pelicula> buscarPeliculaPorId(Long id) {
		return peliculaDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pelicula> buscarPeliculaPorTitulo(String titulo) {
		return peliculaDao.findByTitulo(titulo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> listarPeliculasOrdenadaPorFecha(Sort sort) {
		return peliculaDao.findAll(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> buscarPeliculasPorGenero(Genero genero) {
		return peliculaDao.findByGenero(genero);
	}

}
