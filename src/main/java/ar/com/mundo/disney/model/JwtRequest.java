package ar.com.mundo.disney.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable{
	
	private static final long serialVersionUID = 3792793418311369432L;

	private String username;
	
	private String password;
}
