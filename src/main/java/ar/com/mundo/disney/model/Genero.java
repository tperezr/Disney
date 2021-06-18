package ar.com.mundo.disney.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Genero {
	
	@Id
	@Column(name = "id_genero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGenero;
	
	@NotEmpty
	private String nombre;
	
	private String imagen;
	
	@OneToMany(mappedBy = "genero")
	private List<Pelicula> peliculas;
}
