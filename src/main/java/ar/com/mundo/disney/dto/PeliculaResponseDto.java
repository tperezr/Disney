package ar.com.mundo.disney.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeliculaResponseDto{

	private String imagen;
	private String titulo;
	private Date fechaCreacion;
}
