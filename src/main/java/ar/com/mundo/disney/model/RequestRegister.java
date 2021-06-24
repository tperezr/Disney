package ar.com.mundo.disney.model;

import lombok.Data;

@Data
public class RequestRegister {
	
	private String username;
	private String password;
	private String email;
	
}
