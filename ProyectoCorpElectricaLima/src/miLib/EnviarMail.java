package miLib;

import gui.TranCotizacionAutMant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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

import beans.GlobalesCorreo;
import beans.GlobalesCorreoMasivo;
import beans.GlobalesCorreoProve;

public class EnviarMail {

	public static int Enviar1(String correo1, String asunto1, String archivo1,
			String mensaje1) {
		
		GlobalesCorreo objGlobal = null;
		String correo = correo1;
		String asunto = asunto1;
		System.out.println("Moises: Este la función Enviar1 del archivo EnviarMail.java");

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			// multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	/*************************************************************************************************************/
	public static int Enviar2(String correo1, String asunto1, String archivo1,
			String mensaje1) {
		GlobalesCorreoProve objGlobal = null;
		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		// String mensaje=mensaje1;
		// String nombreArchivo=nombreArchivo1;
		
		System.out.println("Moises: Este la funciòn Enviar2 del archivo EnviarMail.java");

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			// multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}
	
	//Moises: Nueva función para envío de correos masivos
	public static int EnviarCorreosMasivos(String correo1, String asunto1, String mensaje1) {
		// Globales objGlobal = null;
		
		System.out.println("Moises: Este la funciòn Enviar del archivo EnviarMail.java");	
		
		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		//String archivo = archivo1;
		String mensaje = mensaje1;
		//String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de

			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);

			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);
			*/

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			//multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));

			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);

			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}
	
	
	
	public static int Enviar(String correo1, String asunto1, String mensaje1) {
		// Globales objGlobal = null;
		
		System.out.println("Moises: Este la funciòn Enviar del archivo EnviarMail.java");	
		
		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String mensaje = mensaje1;
		int regreso = 0;
		try {

			Properties props = new Properties(); // de
			// props.put("mail.smtp.host", "smtp.gmail.com");
			// props.put("mail.smtp.host", "smtp.live.com");
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			// props.setProperty("mail.smtp.user", "gcorreacaja@gmail.com");
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			// multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			// message.setFrom(new InternetAddress("gcorreageek@gmail.com"));
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}// para
				// message.addRecipient( Message.RecipientType.TO, new
				// InternetAddress(correo));//para

			message.setSubject(asunto);// de
			// message.addHeader("Disposition-Notification-To",
			// "gcorreageek@gmail.com");
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
			// System.out.println("yeah");
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	public static int EnviarConCopia(String correo1, String correo2,
			String asunto1, String mensaje1) {
		// Globales objGlobal = null;
		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String mensaje = mensaje1;
		int regreso = 0;
		try {

			Properties props = new Properties(); // de
			// props.put("mail.smtp.host", "smtp.gmail.com");
			// props.put("mail.smtp.host", "smtp.live.com");
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			// props.setProperty("mail.smtp.user", "gcorreacaja@gmail.com");
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			// multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			// message.setFrom(new InternetAddress("gcorreageek@gmail.com"));
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(correo2));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}// para
				// message.addRecipient( Message.RecipientType.TO, new
				// InternetAddress(correo));//para

			message.setSubject(asunto);// de
			// message.addHeader("Disposition-Notification-To",
			// "gcorreageek@gmail.com");
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
			// System.out.println("yeah");
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	public static int Enviar(String correo1, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {

		TranCotizacionAutMant objcot = new TranCotizacionAutMant();
		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String mensaje = mensaje1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {

			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);

			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);

			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));

			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);

			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);

			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	/********************************************************************************************************/
	public static int EnviarOC(String correo1, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {

		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String mensaje = mensaje1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de

			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);

			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));

			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);

			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	/****************************************************************************************************************************************************/

	public static int EnviarCorreoCotizacionMant(String correo1,
			String correo2, String asunto, String nombreArchivos,
			String archivos, String mensaje,int adj) {

		//TranCotizacionAutMant objcot = new TranCotizacionAutMant();
		GlobalesCorreo objGlobal = null;
		int regreso = 0;
		
		try {
						
			// se obtiene el objeto Session. La configuración es para
			// una cuenta de gmail.
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);

			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);

			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");

			Session session = Session.getDefaultInstance(props, null);		
			
			BodyPart firma = new MimeBodyPart();
			firma.setContent(mensaje, "text/html");
			
			
			if(adj==0){
				// Se compone el adjunto con la imagen
				
				BodyPart adjunto = new MimeBodyPart();
				adjunto.setDataHandler(new DataHandler(new FileDataSource(archivos)));
				adjunto.setFileName(nombreArchivos);

				MimeMultipart multiParte = new MimeMultipart();
				multiParte.addBodyPart(firma);
				multiParte.addBodyPart(adjunto);
				
				// de
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(objGlobal.correo,
						objGlobal.nombre));

				try {
					if(correo2.equals("") || correo2==null){
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(correo1));
					}else{
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(correo1));// para
						message.addRecipient(Message.RecipientType.CC,
								new InternetAddress(correo2));
					}
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					regreso = 1;
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					regreso = 1;
				} catch (Exception e)
				{
					e.printStackTrace();
				}

				System.out.println("Ningún problema con el ADJUNTO");
				
				message.setSubject(asunto);// de
				message.addHeader("Disposition-Notification-To",
						objGlobal.correoError);

				message.setContent(multiParte);
				
				System.out.println("Ningún problema con el ASUNTO");
				
				// de
				Transport t = session.getTransport("smtp");
				t.connect(objGlobal.correo, objGlobal.pass);

				t.sendMessage(message, message.getAllRecipients());
				t.close();
				regreso = 0;
				
			}else{
				/***********************************************************************************************/
				System.out.println("Entro con Adjuntos");
				String archivos_adjuntos = archivos;
				String archivos_adjuntos_nombre = nombreArchivos;
				String patron = ";";
				String[] dividido_adj, dividido_adj_nom;
				dividido_adj = archivos_adjuntos.split(patron);
				dividido_adj_nom = archivos_adjuntos_nombre.split(patron);
				// Se compone la parte del texto
				List<BodyPart> bp = new LinkedList<BodyPart>();// <-------creamos
																// una lista de
																// adjuntos
				// Se compone el adjunto con la imagen

				for (int i = 0; i <= dividido_adj.length - 1; i++) {
					BodyPart adjunto = new MimeBodyPart();
					adjunto.setDataHandler(new DataHandler(new FileDataSource(
							dividido_adj[i])));
					adjunto.setFileName(dividido_adj_nom[i]);
					bp.add(adjunto);// <----------------añadimos el elemento a la
									// lista
				}

				// Una MultiParte para agrupar texto e imagen.
				MimeMultipart multiParte = new MimeMultipart();
				multiParte.addBodyPart(firma);

				Iterator<BodyPart> it = bp.iterator();// <------------la iteramos
				while (it.hasNext())// <----------------la recorremos
				{
					BodyPart attach = (BodyPart) it.next();// <------------obtenemos
															// el objeto
					multiParte.addBodyPart(attach);// <-----------------finalmente
													// lo añadimos al mensaje
				}
				/*****************************************************************************************************/
						
				// Se compone el correo, dando to, from, subject y el
				// contenido.
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(objGlobal.correo,
						objGlobal.nombre));
							
				try {
					if(correo2.equals("") || correo2==null){
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(correo1));
					}else{
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(correo1));// para
						message.addRecipient(Message.RecipientType.CC,
								new InternetAddress(correo2));
					}
					
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					regreso = 1;
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					regreso = 1;
				}
	
				message.setSubject(asunto);// de
				message.addHeader("Disposition-Notification-To",
						objGlobal.correoError);
	
				message.setContent(multiParte);
				
				// Se envia el correo.
				Transport t = session.getTransport("smtp");
				t.connect(objGlobal.correo, objGlobal.pass);
				t.sendMessage(message, message.getAllRecipients());
				t.close();
				regreso = 0;
			}
		} catch (Exception e) {
			regreso = 1;
			e.printStackTrace();
			// TODO: handle exception
		} 
		/*finally {
			if (regreso == 1)
				regreso = 1;
		}
		*/
		return regreso;
	}

	/****************************************************************************************************************************************************/
	public static int Enviar(String correo1, String correo2, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {

		System.out.println("Este es el verdadero envío de la COTIZACIÓN;");
		
		TranCotizacionAutMant objcot = new TranCotizacionAutMant();
		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);

			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);

			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));

			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(correo2));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);

			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);

			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	public static int EnviarMantcli2(String correo1, String correo2,
			String asunto1, String nombreArchivo1, String archivo1,
			String mensaje1) {

		GlobalesCorreo objGlobal = null;
		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(correo2));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	/********************************************************************************************************************************/
	public static int EnviarOC(String correo1, String correo2, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {

		GlobalesCorreo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String mensaje = mensaje1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de

			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));

			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(correo2));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);

			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);

			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	/********************************************************************************************************************************/

	public static int Enviar1(String correo1, String correo2, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {

		GlobalesCorreo objGlobal = null;
		String correo = correo1;
		String asunto = asunto1;
		// String archivo=archivo1;
		// String archivos=archivo2;
		// String mensaje=mensaje1;
		// String nombreArchivo=nombreArchivo1;
		// String nombreArchivos=nombreArchivo2;
		String[] attachments = { archivo1 };
		String[] nombres = { nombreArchivo1 };
		int conta = 0;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			props.put("mail.smtp.host", objGlobal.extension);
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587"); // de
			props.setProperty("mail.smtp.user", objGlobal.correo);
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.debug", "true");
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte1 = new MimeMultipart();
			multiParte1.addBodyPart(firma);

			for (int i = 0; i < 1; i++) {

				conta++;

				System.out.println("Nº:" + conta);
				String filename = attachments[i];
				System.out.println("Este es el archivo: " + filename);
				String nom = nombres[i];
				System.out.println("Este es el nombre: " + nom);

				MimeBodyPart adjunto1 = new MimeBodyPart();
				// use a JAF FileDataSource as it does MIME type detection n
				DataSource source = new FileDataSource(filename);
				adjunto1.setDataHandler(new DataHandler(source));
				adjunto1.setFileName(nom);
				// add the attachment
				multiParte1.addBodyPart(adjunto1, i);

			}

			// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// Se compone el adjunto con la imagen

			// adjunto.setFileName(nombreArchivos);

			/*
			 * //zlxmzlxm<zxm<kxm<kxmñkxmñzkmñkxmz<x BodyPart adjunto2 = new
			 * MimeBodyPart(); adjunto2.setDataHandler( new DataHandler(new
			 * FileDataSource(archivos))); adjunto2.setFileName(nombreArchivos);
			 */

			/*
			 * MimeMultipart multiParte = new MimeMultipart();
			 * multiParte.addBodyPart(firma); multiParte.addBodyPart(adjunto);
			 * 
			 * //multiParte.addBodyPart(adjunto2);
			 * 
			 * //baksjbaskjdbaskjdaskjdbaskjdbskaj /* MimeMultipart multiParte2
			 * = new MimeMultipart(); multiParte2.addBodyPart(adjunto2);
			 */

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(correo2));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}

			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte1);
			// message.setContent(multiParte2);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;

		} catch (Exception e) {
			System.out.println("SALIO MAL");
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	public void generarZip() {

		String[] filenames = new String[] { "D:\\01.java", "D:\\02.java",
				"D:\\03.txt" };
		// Crear un bufer para leer los archivos
		byte[] buf = new byte[1024];
		try {
			// Crear el archivo ZIP
			String outFilename = "D:\\outfile.zip";
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					outFilename));
			// Comprimir los archivos
			FileInputStream in;
			for (int i = 0; i < 1; i++) {
				in = new FileInputStream(filenames[i]);

				// Agregar las entradas ZIP al outputstream.
				out.putNextEntry(new ZipEntry(filenames[i]));
				// Transferencia de bytes desde el archivo original al archivo
				// ZIP
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
				out.close();

			}
		} catch (IOException e) {

		}

	}

	/*******************************************************************************************************************************/
	/*
	 * protected void addAtachments(String[] attachments, Multipart multipart)
	 * 
	 * throws MessagingException, AddressException {
	 * 
	 * for (int i = 0; i <= attachments.length - 1; i++) {
	 * 
	 * String filename = attachments[i];
	 * 
	 * MimeBodyPart adjunto = new MimeBodyPart(); //use a JAF FileDataSource as
	 * it does MIME type detection DataSource source = new
	 * FileDataSource(filename); adjunto.setDataHandler(new
	 * DataHandler(source)); adjunto.setFileName(filename); //add the attachment
	 * multipart.addBodyPart(adjunto);
	 * 
	 * //////////////////////////////////////////////////////////////////////////
	 * /
	 * 
	 * BodyPart adjunto2 = new MimeBodyPart(); adjunto2.setDataHandler( new
	 * DataHandler(new FileDataSource(filename))); //
	 * adjunto2.setFileName(nombreArchivos);
	 * 
	 * MimeMultipart multiParte = new MimeMultipart(); //
	 * multiParte.addBodyPart(firma); multiParte.addBodyPart(adjunto);
	 * multiParte.addBodyPart(adjunto2);
	 * 
	 * }
	 * 
	 * }
	 */

	/*******************************************************************************
	 * /************************************************************************
	 * *******
	 * 
	 * 
	 * MASIVO
	 */
	public static int EnviarMasivo(String correo1, String asunto1,
			String mensaje1) {
		// Globales objGlobal = null;
		GlobalesCorreoMasivo objGlobal = null;

		String correo = correo1;
		String asunto = asunto1;
		String mensaje = mensaje1;
		int regreso = 0;
		try {

			Properties props = new Properties(); // de
			/*
			 * props.put("mail.smtp.host", objGlobal.extension);
			 * props.setProperty("mail.smtp.starttls.enable", "true");
			 * props.setProperty("mail.smtp.port", "587"); //de
			 * //props.setProperty("mail.smtp.user", "gcorreacaja@gmail.com");
			 * props.setProperty("mail.smtp.user", objGlobal.correo);
			 * props.setProperty("mail.smtp.auth", "true");
			 * props.setProperty("mail.smtp.debug", "true");
			 */
			props.put("mail.smtp.host", objGlobal.extension);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.setProperty("mail.user", objGlobal.correo);
			props.setProperty("mail.password", objGlobal.pass);

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			/*
			 * BodyPart adjunto = new MimeBodyPart(); adjunto.setDataHandler(
			 * new DataHandler(new FileDataSource(archivo)));
			 * adjunto.setFileName(nombreArchivo);
			 */

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			// multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			// message.setFrom(new InternetAddress("gcorreageek@gmail.com"));
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}// para
				// message.addRecipient( Message.RecipientType.TO, new
				// InternetAddress(correo));//para

			message.setSubject(asunto);// de
			// message.addHeader("Disposition-Notification-To",
			// "gcorreageek@gmail.com");
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
			// System.out.println("yeah");
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}

	public static int EnviarMasivo(String correo1, String asunto1,
			String nombreArchivo1, String archivo1, String mensaje1) {
		GlobalesCorreoMasivo objGlobal = null;
		String correo = correo1;
		String asunto = asunto1;
		String archivo = archivo1;
		String mensaje = mensaje1;
		String nombreArchivo = nombreArchivo1;

		int regreso = 0;
		try {
			Properties props = new Properties(); // de
			/*
			 * props.put("mail.smtp.host", objGlobal.extension);
			 * props.setProperty("mail.smtp.starttls.enable", "true");
			 * props.setProperty("mail.smtp.port", "587"); //de
			 * props.setProperty("mail.smtp.user",objGlobal.correo);
			 * props.setProperty("mail.smtp.auth", "true");
			 * props.setProperty("mail.smtp.debug", "true");
			 */
			props.put("mail.smtp.host", objGlobal.extension);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.setProperty("mail.user", objGlobal.correo);
			props.setProperty("mail.password", objGlobal.pass);
			// String nombre=objGlobal.NOM_VEN;

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			/*
			 * BodyPart texto = new MimeBodyPart(); texto.setText(mensaje);
			 */

			BodyPart firma = new MimeBodyPart();
			// texto.setContent(fichero,"text/html");
			firma.setContent(mensaje1, "text/html");

			// Se compone el adjunto con la imagen
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
			adjunto.setFileName(nombreArchivo);

			MimeMultipart multiParte = new MimeMultipart();
			// multiParte.addBodyPart(texto);
			multiParte.addBodyPart(firma);
			multiParte.addBodyPart(adjunto);

			// de
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(objGlobal.correo,
					objGlobal.nombre));
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo));// para
				// message.addRecipient( Message.RecipientType.CC, new
				// InternetAddress("GCORREAGEEK@GMAIL.COM"));
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				regreso = 1;
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				regreso = 1;
			}
			message.setSubject(asunto);// de
			message.addHeader("Disposition-Notification-To",
					objGlobal.correoError);
			message.setContent(multiParte);

			// de
			Transport t = session.getTransport("smtp");
			t.connect(objGlobal.correo, objGlobal.pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			regreso = 0;
		} catch (Exception e) {
			regreso = 1;
			// TODO: handle exception
		} finally {
			if (regreso == 1)
				regreso = 1;
		}
		return regreso;
	}
	/*
	 * public static int enviarMail(String correo1,String asunto1,String
	 * archivo1,String mensaje1){ Globales objGlobal = null;
	 * 
	 * System.out.println("2"+correo1); System.out.println("2"+asunto1);
	 * System.out.println("2"+archivo1); System.out.println("2"+mensaje1);
	 * String correo=correo1; String asunto=asunto1; String archivo=archivo1;
	 * String mensaje=mensaje1; String nombreArchivo=archivo.substring(38,
	 * archivo.length()); System.out.println("1"+correo1);
	 * System.out.println("1"+asunto1); System.out.println("1"+archivo1);
	 * System.out.println("1"+mensaje1); System.out.println("1"+nombreArchivo);
	 * int regreso=0; try { Properties props = new Properties(); //de
	 * props.put("mail.smtp.host", "smtp.gmail.com");
	 * props.setProperty("mail.smtp.starttls.enable", "true");
	 * props.setProperty("mail.smtp.port", "587"); //de
	 * props.setProperty("mail.smtp.user",
	 * "corporacionelectricalima@gmail.com");
	 * props.setProperty("mail.smtp.auth", "true");
	 * props.setProperty("mail.smtp.debug", "true"); String
	 * nombre=objGlobal.NOM_VEN;
	 * 
	 * Session session = Session.getDefaultInstance(props, null); //
	 * session.setDebug(true);
	 * 
	 * 
	 * 
	 * 
	 * BodyPart firma = new MimeBodyPart (); //
	 * texto.setContent(fichero,"text/html"); firma.setContent( mensaje1+
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 153);\">&nbsp;</p>"
	 * +
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"
	 * +
	 * "<font style=\"font-size: 13pt;\">Saludos Cordiales</font></i></b></p>"+
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">"
	 * + "<span style=\"font-size: 13pt;\"><b><i>"+nombre+"</i></b></span></p>"+
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">&nbsp;</p>"
	 * +
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\">&nbsp;</p>"
	 * + "<font style=\"font-size: 13pt;\">"+
	 * "<a href=\"http://www.corporacionelectricalima.com/\" target=\"_blank\">"
	 * +
	 * "<img alt=\"CORPORACION ELECTRICA LIMA\" src=\"http://www.corporacionelectricalima.com/cabezerasyotros/logoparamensaje2.gif\"></a></font></i></b></p>"
	 * +
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"
	 * + "<font style=\"font-size: 13pt;\">&nbsp;</font></i></b></p>"+
	 * "<p style=\"margin-top: 0pt; margin-bottom: 0pt; color: rgb(0, 0, 102);\"><b><i>"
	 * +
	 * "<font style=\"font-size: 13pt;\">Corporación Eléctrica Lima</font></i></b></p>"
	 * +
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"
	 * + "<font size=\"2.5\">Ruc 20492885810</font></p>"+
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"
	 * + "<font size=\"2.5\">RPM # 630911 # 630908</font></p>"+
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"
	 * +
	 * 
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\">"
	 * + "<font size=\"2.5\">Cel 99809 9460&nbsp; 99809 6092</font></p>"+
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt; color: rgb(0, 0, 153);\"><font size=\"2.5\">Nextel 818*3869&nbsp; 823*9230<br>"
	 * + "</font></p>"+
	 * "<font size=\"2.5\">Telefax 540-1879&nbsp; 540-3863</font></p>"+
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt;\">"
	 * + "<font size=\"2.5\">"+ "<a>"+
	 * "<b>corporacionelectricalima@<wbr>gmail.com</b></a></font></p>"+
	 * "<p style=\"margin-top: 0pt; font-family: tahoma,sans-serif; margin-bottom: 0pt;\">"
	 * +
	 * "<a href=\"http://www.corporacionelectricalima.com/\" target=\"_blank\">"
	 * +
	 * "<font size=\"2.5\"><b>www.corporacionelectricalima.<wbr>com</b></font></a></p>"
	 * ,"text/html");
	 * 
	 * 
	 * 
	 * // Se compone el adjunto con la imagen BodyPart adjunto = new
	 * MimeBodyPart(); adjunto.setDataHandler( new DataHandler(new
	 * FileDataSource(archivo))); adjunto.setFileName(nombreArchivo);
	 * 
	 * 
	 * 
	 * MimeMultipart multiParte = new MimeMultipart(); //
	 * multiParte.addBodyPart(texto); multiParte.addBodyPart(firma);
	 * multiParte.addBodyPart(adjunto);
	 * 
	 * 
	 * //de MimeMessage message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress("corporacionelectricalima@gmail.com"));
	 * message.addRecipient( Message.RecipientType.TO, new
	 * InternetAddress(correo));//para
	 * 
	 * 
	 * message.setSubject(asunto);//de
	 * message.addHeader("Disposition-Notification-To",
	 * "corporacionelectricalima@gmail.com"); message.setContent(multiParte);
	 * 
	 * //de Transport t = session.getTransport("smtp");
	 * t.connect("corporacionelectricalima@gmail.com", "archimillonario");
	 * t.sendMessage(message, message.getAllRecipients()); t.close(); regreso=0;
	 * //System.out.println("yeah"); } catch (Exception e) { regreso=1; // TODO:
	 * handle exception }finally{ if(regreso==1)regreso=1; } return regreso; }
	 */

}
