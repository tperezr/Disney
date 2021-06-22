package ar.com.mundo.disney.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
public class Pelicula {
	
	@Id
	@Column(name="id_pelicula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCreacion;
	
	@NotEmpty
	private Integer calificacion;
	
	private String imagen;
	
	@ManyToMany
	@JoinTable(
		name = "pelicula_personaje",
		joinColumns = @JoinColumn(name="id_pelicula"),
		inverseJoinColumns = @JoinColumn(name = "id_personaje")
	)
	private List<Personaje> personajes;
	
	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero;

	public Pelicula(Long id) {
		super();
		this.id = id;
	}
	
	
}

