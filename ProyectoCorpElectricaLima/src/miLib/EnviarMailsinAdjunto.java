package miLib;


import java.util.Properties;

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


public class EnviarMailsinAdjunto {
	
	public static int Enviar(String correo1,String asunto1,String mensaje1){
	//	Globales objGlobal = null;
	
		String correo=correo1;
		String asunto=asunto1;
		String mensaje=mensaje1;
		int regreso=0;
		try {
			 Properties props = new Properties(); //de
             props.put("mail.smtp.host", "smtp.gmail.com");
             props.setProperty("mail.smtp.starttls.enable", "true");
             props.setProperty("mail.smtp.port", "587"); //de
             props.setProperty("mail.smtp.user", "electro.cornejo02@gmail.com");
             props.setProperty("mail.smtp.auth", "true");
             props.setProperty("mail.smtp.debug", "true");
			String nombre="";
			
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
             message.setFrom(new InternetAddress("electro.cornejo02@gmail.com"));
             try {
				message.addRecipient( Message.RecipientType.TO, new InternetAddress(correo));
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
             message.addHeader("Disposition-Notification-To", "electro.cornejo02@gmail.com");
             message.setContent(multiParte);
           
             //de
             Transport t = session.getTransport("smtp");
             t.connect("electro.cornejo02@gmail.com", "archimillonario");
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
	
	
	
	
	
	
	
	
}
