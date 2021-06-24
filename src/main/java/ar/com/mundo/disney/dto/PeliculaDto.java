package ar.com.mundo.disney.dto;

import java.util.Date;

import ar.com.mundo.disney.model.Genero;
import lombok.Data;

@Data
public class PeliculaDto {
	
	private Long id;
	private String titulo;
	private Date fechaCreacion;	
	private Integer calificacion;
	private String imagen;
	private Genero genero;

}
