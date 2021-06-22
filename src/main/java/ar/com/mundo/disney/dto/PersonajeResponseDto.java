package ar.com.mundo.disney.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeResponseDto {
	
	private String nombre;
	private String imagen;
}
