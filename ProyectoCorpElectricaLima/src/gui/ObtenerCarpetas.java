package gui;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;

	public class ObtenerCarpetas {
		static Folder universidadFolder;
		
	public static void main (String [] args) {
		
	if (args.length != 2) {
	System.out.println( "Ha de enviar dos parámetros\n" +
	"java ObtenerCorreoIMAP usuario clave");
	//System.exit(1);
	}
	// Obtener el usuario y la clave recibidos como parámetros
	String usuario = "jonatant16@gmail.com";
	String clave = "2012doomsday";
	// Obtener las propiedades del sistema
	String popHost = "imap.gmail.com";
	Properties props = System.getProperties();
	// Obtener una sesión con las propiedades anteriormente definidas
	Session sesion = Session.getDefaultInstance(props,null);
	try {
	// Crear un Store indicando el protocolo de acceso y
	// conectarse a él
	Store store = sesion.getStore("imap");
	store.connect(popHost,usuario,clave);
	// Crear un objeto Folder y obtener la carpeta por defecto
	Folder folder = store.getDefaultFolder();
	if ((folder.getType() & Folder.HOLDS_FOLDERS) != 0) {
	//==========================================
	// Crear una carpeta llamada Universidad
	//==========================================
	universidadFolder = store.getFolder("PRUEBAS");
	universidadFolder.create(Folder.HOLDS_MESSAGES);
	//==========================================
	// Obtener las carpetas almacenadas bajo la carpeta por defecto
	//==========================================
	Folder [] listaCarpetas = folder.list("*");
	// Nombre de cada carpeta y sus atributos
	      for (int i = 0; i < listaCarpetas.length; i++) {
	System.out.println("Carpeta:" +
			listaCarpetas[i].getFullName());
			IMAPFolder imf = (IMAPFolder)listaCarpetas[i];
			String [] atributos = imf.getAttributes();
			System.out.println ("\t" + "Atributos: ");
			for (int j= 0; j < atributos.length; j++)
			System.out.println ("\t" + atributos[j] + "\n");
			//Carpeta padre de cada carpeta
			System.out.println ("\t"+ "Carpeta Padre: " +
			listaCarpetas[i].getParent().getName() + "\n");
			
			}
			}
	
			//==========================
			// Copiar mensajes
			//==========================
			Message [] mensajesCopiar = new Message[2];
			Folder trashFolder = store.getFolder("[Gmail]/Papelera");//EN ESTA CARPETA SE COPIAN LOS MENSAJES
			trashFolder.open (Folder.READ_WRITE);
			Folder INBOXFolder = store.getFolder("[Gmail]/Enviados");//DE ESTA CARPETA SALEN LOS MENSAJES QUE SE VAN A COPIAR
			INBOXFolder.open (Folder.READ_ONLY);
			// Concatenar a la lista de mensajes de la carpeta que le pasamos
			// como parámetro, el array de mensajes formado con los mensajes
			// de la carpeta origen
			mensajesCopiar[0] = INBOXFolder.getMessage(1);
			mensajesCopiar[1] = INBOXFolder.getMessage(2);
			INBOXFolder.copyMessages(mensajesCopiar,trashFolder);
			INBOXFolder.close(false);
			//==============================================
			// Obtener los mensajes de la carpeta INBOX.Trash
			//==============================================
			Message [] mensajes = trashFolder.getMessages();
			// Procesar los mensajes
			for (int i= 0; i < mensajes.length; i++) {
			System.out.println("Mensaje " + i + ":\n" +
			"\tAsunto: " + mensajes[i].getSubject() + "\n" +
			"\tRemitente: " + mensajes[i].getFrom()[0] + "\n" +
			"\tFecha de Envío: " + mensajes[i].getSentDate() + "\n" +
			"\tContenido: " + mensajes[i].getContent() + "\n");
			}
			trashFolder.close(false);
			//==========================
			// Borrar una carpeta
			//==========================
			universidadFolder.delete(false);
			//universidadFolder.delete(false);
			store.close();
			} catch (MessagingException me) {
			System.err.println(me.toString());
			} catch (IOException ioe) {
			System.err.println(ioe.toString());
			}
			}
			}