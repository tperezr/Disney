package ar.com.mundo.disney;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DisneyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO: Test cruds
		
	}
}
