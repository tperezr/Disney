package ar.com.mundo.disney.util;

import org.springframework.stereotype.Service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import ar.com.mundo.disney.model.RequestRegister;
import java.io.IOException;

@Service
public class SengridMailSender {
	
	public Response sendEmail(RequestRegister usuario) throws IOException {
		Email from = new Email("tomas.p.r7@gmail.com");
	    String subject = "Bienvenido a Disney World";
	    Email to = new Email(usuario.getEmail());
	    Content content = new Content("text/plain",
	    		"Hola " + usuario.getUsername()
	    		+ "\nAhora podrás disfrutar de tus peliculas y series favoritas");
	    Mail mail = new Mail(from, subject, to, content);
	    
	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
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
