package ar.com.mundo.disney.dto;

import java.util.Date;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDto {
	
	private Long id;
	private String titulo;
	private Date fechaCreacion;	
	private Integer calificacion;
	private String imagen;
	private String genero;
}
