package miLib;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import beans.GlobalesCorreoProve;

public class EnviarMailProve {
	
	
	public static  int Enviar1(String correo1,String asunto1,String archivo1,String mensaje1){
		GlobalesCorreoProve objGlobal = null;
		String correo=correo1;
		String asunto=asunto1;
		String archivo=archivo1;
		//String mensaje=mensaje1;
		//String nombreArchivo=nombreArchivo1;
		
		int regreso=0;
		try {
			 Properties props = new Properties(); //de
             props.put("mail.smtp.host", objGlobal.extension);
             props.setProperty("mail.smtp.starttls.enable", "true");
             props.setProperty("mail.smtp.port", "587"); //de
             props.setProperty("mail.smtp.user",objGlobal.correo);
             props.setProperty("mail.smtp.auth", "true");
             props.setProperty("mail.smtp.debug", "true");
			//String nombre=objGlobal.NOM_VEN;
			
             Session session = Session.getDefaultInstance(props, null);
             // session.setDebug(true);

             // Se compone la parte del texto
             /*BodyPart texto = new MimeBodyPart();
             texto.setText(mensaje);*/
             
          
             BodyPart firma = new MimeBodyPart ();
            // texto.setContent(fichero,"text/html");
             firma.setContent( mensaje1,"text/html");
          
			

             // Se compone el adjunto con la imagen
            /* BodyPart adjunto = new MimeBodyPart();
             adjunto.setDataHandler( new DataHandler(new FileDataSource(archivo))); 
            adjunto.setFileName(nombreArchivo);*/
                
            
			
             MimeMultipart multiParte = new MimeMultipart();
          //   multiParte.addBodyPart(texto);
             multiParte.addBodyPart(firma);
           //  multiParte.addBodyPart(adjunto);
            
          
             //de
             MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress(objGlobal.correo, objGlobal.nombre));
             try {
            	 message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));//para
            	 //message.addRecipient( Message.RecipientType.CC, new InternetAddress("GCORREAGEEK@GMAIL.COM"));
 			} catch (AddressException e) {
 				// TODO Auto-generated catch block
 				regreso=1;
 				e.printStackTrace();
 			} catch (MessagingException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 				regreso=1;
 			}
            
                
                
             message.setSubject(asunto);//de
             message.addHeader("Disposition-Notification-To", objGlobal.correoError);
             message.setContent(multiParte);
           
             //de
             Transport t = session.getTransport("smtp");
             t.connect(objGlobal.correo, objGlobal.pass);
             t.sendMessage(message, message.getAllRecipients());
             t.close();
             regreso=0;
		} catch (Exception e) {
			regreso=1;
			// TODO: handle exception
		}finally{
			if(regreso==1)regreso=1;
		}
		return regreso;
	}
	
	
	public static int Enviar(String correo1,String asunto1,String mensaje1){
		
			GlobalesCorreoProve objGlobal = null;
			String correo=correo1;
			String asunto=asunto1;
			int regreso=0;
			try {
				
				 Properties props = new Properties(); //de
	            // props.put("mail.smtp.host", "smtp.gmail.com");
				// props.put("mail.smtp.host", "smtp.live.com");
				 props.put("mail.smtp.host", objGlobal.extension);
				 props.setProperty("mail.smtp.starttls.enable", "true");
	             props.setProperty("mail.smtp.port", "587"); //de
	             //props.setProperty("mail.smtp.user", "gcorreacaja@gmail.com");
	             props.setProperty("mail.smtp.user", objGlobal.correo);
	             props.setProperty("mail.smtp.auth", "true");
	             props.setProperty("mail.smtp.debug", "true");
			
				
	             Session session = Session.getDefaultInstance(props, null);
	             // session.setDebug(true);

	             // Se compone la parte del texto
	             /*BodyPart texto = new MimeBodyPart();
	             texto.setText(mensaje);*/
	             
	          
	             BodyPart firma = new MimeBodyPart ();
	            // texto.setContent(fichero,"text/html");
	             firma.setContent( mensaje1,"text/html");
	          
				

	             // Se compone el adjunto con la imagen
	             /*BodyPart adjunto = new MimeBodyPart();
	             adjunto.setDataHandler( new DataHandler(new FileDataSource(archivo))); 
	             adjunto.setFileName(nombreArchivo);*/
	                
	            
				
	             MimeMultipart multiParte = new MimeMultipart();
	          //   multiParte.addBodyPart(texto);
	             multiParte.addBodyPart(firma);
	           //  multiParte.addBodyPart(adjunto);
	            
	          
	             //de
	             MimeMessage message = new MimeMessage(session);
	            // message.setFrom(new InternetAddress("gcorreageek@gmail.com"));
	             message.setFrom(new InternetAddress(objGlobal.correo, objGlobal.nombre));
	             try {
					message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));
					//message.addRecipient( Message.RecipientType.CC, new InternetAddress("GCORREAGEEK@GMAIL.COM"));
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					regreso=1;
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					regreso=1;
				}//para
	            // message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));//para
	                
	                
	             message.setSubject(asunto);//de
	            // message.addHeader("Disposition-Notification-To", "gcorreageek@gmail.com");
	             message.addHeader("Disposition-Notification-To", objGlobal.correoError);
	             message.setContent(multiParte);
	           
	             //de
	             Transport t = session.getTransport("smtp");
	             t.connect(objGlobal.correo, objGlobal.pass);
	             t.sendMessage(message, message.getAllRecipients());
	             t.close();
	             regreso=0;
		//System.out.println("yeah");
			} catch (Exception e) {
				regreso=1;
				// TODO: handle exception
			}finally{
				if(regreso==1)regreso=1;
			}
			return regreso;
		}
		
		
		public static  int Enviar(String correo1,String asunto1,String nombreArchivo1,String archivo1,String mensaje1){
			
			GlobalesCorreoProve objGlobal = null;
			String correo=correo1;
			String asunto=asunto1;
			String archivo=archivo1;
			String nombreArchivo=nombreArchivo1;
			
			int regreso=0;
			try {
				 Properties props = new Properties(); //de
	             props.put("mail.smtp.host", objGlobal.extension);
	             props.setProperty("mail.smtp.starttls.enable", "true");
	             props.setProperty("mail.smtp.port", "587"); //de
	             props.setProperty("mail.smtp.user",objGlobal.correo);
	             props.setProperty("mail.smtp.auth", "true");
	             props.setProperty("mail.smtp.debug", "true");
				//String nombre=objGlobal.NOM_VEN;
				
	             Session session = Session.getDefaultInstance(props, null);
	             // session.setDebug(true);

	             // Se compone la parte del texto
	             /*BodyPart texto = new MimeBodyPart();
	             texto.setText(mensaje);*/
	             
	          
	             BodyPart firma = new MimeBodyPart ();
	            // texto.setContent(fichero,"text/html");
	             firma.setContent( mensaje1,"text/html");
	          
				

	             // Se compone el adjunto con la imagen
	             BodyPart adjunto = new MimeBodyPart();
	             adjunto.setDataHandler( new DataHandler(new FileDataSource(archivo))); 
	             adjunto.setFileName(nombreArchivo);
	                
	            
				
	             MimeMultipart multiParte = new MimeMultipart();
	          //   multiParte.addBodyPart(texto);
	             multiParte.addBodyPart(firma);
	             multiParte.addBodyPart(adjunto);
	            
	          
	             //de
	             MimeMessage message = new MimeMessage(session);
	             message.setFrom(new InternetAddress(objGlobal.correo, objGlobal.nombre));
	             try {
	            	 message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));//para
	            	 //message.addRecipient( Message.RecipientType.CC, new InternetAddress("GCORREAGEEK@GMAIL.COM"));
	 			} catch (AddressException e) {
	 				// TODO Auto-generated catch block
	 				regreso=1;
	 				e.printStackTrace();
	 			} catch (MessagingException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				regreso=1;
	 			}
	            
	                
	                
	             message.setSubject(asunto);//de
	             message.addHeader("Disposition-Notification-To", objGlobal.correoError);
	             message.setContent(multiParte);
	           
	             //de
	             Transport t = session.getTransport("smtp");
	             t.connect(objGlobal.correo, objGlobal.pass);
	             t.sendMessage(message, message.getAllRecipients());
	             t.close();
	             regreso=0;
			} catch (Exception e) {
				regreso=1;
				// TODO: handle exception
			}finally{
				if(regreso==1)regreso=1;
			}
			return regreso;
		}
		
		public static  int Enviar(String correo1,String correo2,String asunto1,String nombreArchivo1,String archivo1,String mensaje1){
			GlobalesCorreoProve objGlobal = null;
			String correo=correo1;
			String asunto=asunto1;
			String archivo=archivo1;
			String mensaje=mensaje1;
			String nombreArchivo=nombreArchivo1;
			
			int regreso=0;
			try {
				 Properties props = new Properties(); //de
	             props.put("mail.smtp.host", objGlobal.extension);
	             props.setProperty("mail.smtp.starttls.enable", "true");
	             props.setProperty("mail.smtp.port", "587"); //de
	             props.setProperty("mail.smtp.user",objGlobal.correo);
	             props.setProperty("mail.smtp.auth", "true");
	             props.setProperty("mail.smtp.debug", "true");
				//String nombre=objGlobal.NOM_VEN;
				
	             Session session = Session.getDefaultInstance(props, null);
	             // session.setDebug(true);

	             // Se compone la parte del texto
	             /*BodyPart texto = new MimeBodyPart();
	             texto.setText(mensaje);*/
	             
	          
	             BodyPart firma = new MimeBodyPart ();
	            // texto.setContent(fichero,"text/html");
	             firma.setContent( mensaje1,"text/html");
	          
				

	             // Se compone el adjunto con la imagen
	             BodyPart adjunto = new MimeBodyPart();
	             adjunto.setDataHandler( new DataHandler(new FileDataSource(archivo))); 
	             adjunto.setFileName(nombreArchivo);
	                
	            
				
	             MimeMultipart multiParte = new MimeMultipart();
	          //   multiParte.addBodyPart(texto);
	             multiParte.addBodyPart(firma);
	             multiParte.addBodyPart(adjunto);
	            
	          
	             //de
	             MimeMessage message = new MimeMessage(session);
	             message.setFrom(new InternetAddress(objGlobal.correo, objGlobal.nombre));
	             try {
	            	 message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));//para
	            	 message.addRecipient( Message.RecipientType.CC, new InternetAddress(correo2));
	 			} catch (AddressException e) {
	 				// TODO Auto-generated catch block
	 				regreso=1;
	 				e.printStackTrace();
	 			} catch (MessagingException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				regreso=1;
	 			}
	            
	                
	                
	             message.setSubject(asunto);//de
	             message.addHeader("Disposition-Notification-To", objGlobal.correoError);
	             message.setContent(multiParte);
	           
	             //de
	             Transport t = session.getTransport("smtp");
	             t.connect(objGlobal.correo, objGlobal.pass);
	             t.sendMessage(message, message.getAllRecipients());
	             t.close();
	             regreso=0;
			} catch (Exception e) {
				regreso=1;
				// TODO: handle exception
			}finally{
				if(regreso==1)regreso=1;
			}
			return regreso;
		}
		
	/*public static  int enviarMail(String correo1,String a sunto1,String archivo1,String mensaje1){
		Globales objGlobal = null;
	
		System.out.println("2"+correo1);
		System.out.println("2"+asunto1);
		System.out.println("2"+archivo1);
		System.out.println("2"+mensaje1);
		String correo=correo1;
		String asunto=asunto1;
		String archivo=archivo1;
		String mensaje=mensaje1;
		String nombreArchivo=archivo.substring(38, archivo.length());
		System.out.println("1"+correo1);
		System.out.println("1"+asunto1);
		System.out.println("1"+archivo1);
		System.out.println("1"+mensaje1);
		System.out.println("1"+nombreArchivo);
		int regreso=0;
		try {
			 Properties props = new Properties(); //de
             props.put("mail.smtp.host", "smtp.gmail.com");
             props.setProperty("mail.smtp.starttls.enable", "true");
             props.setProperty("mail.smtp.port", "587"); //de
             props.setProperty("mail.smtp.user", "corporacionelectricalima@gmail.com");
             props.setProperty("mail.smtp.auth", "true");
             props.setProperty("mail.smtp.debug", "true");
			String nombre=objGlobal.NOM_VEN;
			
             Session session = Session.getDefaultInstance(props, null);
             // session.setDebug(true);

             
             
          
             BodyPart firma = new MimeBodyPart ();
            // texto.setContent(fichero,"text/html");
             firma.setContent( mensaje1+"<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 153);\">&nbsp;</p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"+
            		 "<font style=\"font-size: 13pt;\">Saludos Cordiales</font></i></b></p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">"+
            		 "<span style=\"font-size: 13pt;\"><b><i>"+nombre+"</i></b></span></p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">&nbsp;</p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">&nbsp;</p>"+
            		 "<font style=\"font-size: 13pt;\">"+
            		 "<a href=\"http://www.corporacionelectricalima.com/\" target=\"_blank\">"+
            		 "<img alt=\"CORPORACION ELECTRICA LIMA\" src=\"http://www.corporacionelectricalima.com/cabezerasyotros/logoparamensaje2.gif\"></a></font></i></b></p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"+
            		 "<font style=\"font-size: 13pt;\">&nbsp;</font></i></b></p>"+
            		 "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"+
            		 "<font style=\"font-size: 13pt;\">Corporación Eléctrica Lima</font></i></b></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"+
            		 "<font size=\"2.5\">Ruc 20492885810</font></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"+
            		 "<font size=\"2.5\">RPM # 630911 # 630908</font></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"+
            		
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"+
            		 "<font size=\"2.5\">Cel 99809 9460&nbsp; 99809 6092</font></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\"><font size=\"2.5\">Nextel 818*3869&nbsp; 823*9230<br>"+
            		 "</font></p>"+
            		 "<font size=\"2.5\">Telefax 540-1879&nbsp; 540-3863</font></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt;\">"+
            		 "<font size=\"2.5\">"+
            		 "<a>"+
            		 "<b>corporacionelectricalima@<wbr>gmail.com</b></a></font></p>"+
            		 "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt;\">"+
            		 "<a href=\"http://www.corporacionelectricalima.com/\" target=\"_blank\">"+
            		 "<font size=\"2.5\"><b>www.corporacionelectricalima.<wbr>com</b></font></a></p>","text/html");
          
			

             // Se compone el adjunto con la imagen
             BodyPart adjunto = new MimeBodyPart();
             adjunto.setDataHandler( new DataHandler(new FileDataSource(archivo))); 
             adjunto.setFileName(nombreArchivo);
                
            
			
             MimeMultipart multiParte = new MimeMultipart();
          //   multiParte.addBodyPart(texto);
             multiParte.addBodyPart(firma);
             multiParte.addBodyPart(adjunto);
            
          
             //de
             MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress("corporacionelectricalima@gmail.com"));
             message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));//para
                
                
             message.setSubject(asunto);//de
             message.addHeader("Disposition-Notification-To", "corporacionelectricalima@gmail.com");
             message.setContent(multiParte);
           
             //de
             Transport t = session.getTransport("smtp");
             t.connect("corporacionelectricalima@gmail.com", "archimillonario");
             t.sendMessage(message, message.getAllRecipients());
             t.close();
             regreso=0;
	//System.out.println("yeah");
		} catch (Exception e) {
			regreso=1;
			// TODO: handle exception
		}finally{
			if(regreso==1)regreso=1;
		}
		return regreso;
	}
	
	*/
	
	
	
	
	
	
}
