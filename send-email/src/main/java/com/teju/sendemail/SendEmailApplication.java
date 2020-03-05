package com.teju.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class SendEmailApplication implements CommandLineRunner  {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);
	}

	@Override
	public void run(String... args) {
		 System.out.println("Sending Email...");
		 
		 sendEmail();
			//sendEmailWithAttachment();
	     System.out.println("Done");
		
	}
	
	void sendEmail() { 

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("tejashreenabde242@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello Teju, \n Message from Spring Boot Email");

        javaMailSender.send(msg);

    }

    /*void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("tejashreenabde242@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        //helper.setText("<h1>Check attachment for image!</h1>", true);

       // helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }*/

}
