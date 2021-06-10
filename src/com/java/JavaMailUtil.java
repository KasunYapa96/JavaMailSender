package com.java;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.soap.AttachmentPart;

public class JavaMailUtil {


	public static void sendMail() throws MessagingException, IOException {
		
		System.out.println("test class");

		Properties prop=new Properties();
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port","587");
		
		String myAccEmail="kasuny1996@gmail.com";
		String password="Kasunyapa1996";
		
		
		Session session=Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccEmail, password);
			}
			
		});
		
		Message message=new MimeMessage(session);
		message.setSubject("Email From Kasun");
		
		Address addressTo=new InternetAddress("kasunishankayapa1996@gmail.com");
		message.setRecipient(Message.RecipientType.TO, addressTo);
		
		
		MimeMultipart multipart=new MimeMultipart();
		
		
		MimeBodyPart attachment=new MimeBodyPart();
		attachment.attachFile(new File("static/MyResume2021.pdf"));
		
		MimeBodyPart messageBodyPart=new MimeBodyPart();
		messageBodyPart.setContent("<h1>My Email program</h1>", "text/html");
		
		multipart.addBodyPart(messageBodyPart);
		multipart.addBodyPart(attachment);
		
		message.setContent(multipart);
		
		Transport.send(message);
		
	}
		
		
		
	}
		
	
	
	
	

