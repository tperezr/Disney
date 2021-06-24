package ar.com.mundo.disney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Usuario{
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String username;
	private String password;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private List<Rol> roles;
	

}
