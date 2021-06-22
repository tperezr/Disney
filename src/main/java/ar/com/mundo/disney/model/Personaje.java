package ar.com.mundo.disney.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Personaje {

	@Id
	@Column(name = "id_personaje")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonaje;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private Integer edad;
	
	@NotEmpty
	private Integer peso;
	
	@NotEmpty
	private String historia;
	
	private String imagen;
	
	@ManyToMany(mappedBy = "personajes", fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Pelicula> peliculas = new HashSet<Pelicula>();
}
