package ar.com.mundo.disney.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Personaje implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	
	@ManyToMany(mappedBy = "personajes")
	private List<Pelicula> peliculas;
}
