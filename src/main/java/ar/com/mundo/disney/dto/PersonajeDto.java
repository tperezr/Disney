package ar.com.mundo.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDto {

	private Long id;
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	private String imagen;
}
