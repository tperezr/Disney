/*package ar.com.mundo.disney.util;

import org.springframework.beans.factory.annotation.Value;

import com.sendgrid.*;

import ar.com.mundo.disney.model.Usuario;
import java.io.IOException;

public class SengridMailSender {
	
	@Value("${SENDGRID_API_KEY}")
	String key;
	
	public Response sendEmail(Usuario usuario) throws IOException {
		Email from = new Email("tomas.p.r7@gmail.com");
	    String subject = "Bienvenido a Disney World";
	    Email to = new Email(usuario.getEmail());
	    Content content = new Content("text/plain",
	    		"Hola " + usuario.getUsername()
	    		+ "\nAhora podrás disfrutar de tus peliculas y series favoritas");
	    Mail mail = new Mail(from, subject, to, content);
	    
	   
	    
	    SendGrid sg = new SendGrid(key);
	    Request request = new Request();
	    Response response;
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      response = sg.api(request);
	    } catch (IOException ex) {
	      throw ex;
	    }
	    return response;
	}

}
*/