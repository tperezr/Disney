package ar.com.mundo.disney.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {
	
	private Long id;
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	private String imagen;	
	private List<String> peliculas;
	
}
