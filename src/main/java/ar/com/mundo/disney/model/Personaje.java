package ar.com.mundo.disney.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
public class Personaje {

	@Id
	@Column(name = "id_personaje")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
