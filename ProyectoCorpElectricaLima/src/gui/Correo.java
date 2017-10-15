package gui;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Correo {

	public static void main (String [] args) {
		if (args.length != 2) {
		System.out.println( "Ha de enviar dos parámetros\n" +
		"java ManejoBanderas usuario clave");
		//System.exit(1);
		}
		// Obtener el usuario y la clave recibidos como parámetros
		String usuario = "jonatant16@gmail.com";
		String clave = "2012doomsday";
		// Obtener las propiedades del sistema
		String imapHost = "imap.gmail.com";
		Properties props = System.getProperties();
		// Obtener una sesión con las propiedades anteriormente definidas
		Session sesion = Session.getDefaultInstance(props,null);
		// Capturar las excepciones
		try {
		// Crear un Store indicando el protocolo de acceso y conectarse a él
		Store store = sesion.getStore("imap");
		store.connect(imapHost,usuario,clave);
		// Crear un Folder y abrir la carpeta INBOX en modo
		// LECTURA/ESCRITURA
		Folder folder = store.getFolder("INBOX");
		// Si se abriese en modo de sólo lectura no se podrían marcar los
		// mensajes y por tanto parecerá que no se soporta ningún banderín
		folder.open(Folder.READ_WRITE);
		// Obtener las banderas soportadas y mostramos cuáles son
		Flags banderasSoportadas = folder.getPermanentFlags();
		if (banderasSoportadas.contains(Flags.Flag.ANSWERED))
		System.out.println("Soporta el banderín ANSWERED\n");
		else
		System.out.println("No soporta el banderín ANSWERED\n");
		if (banderasSoportadas.contains(Flags.Flag.DELETED))
		System.out.println("Soporta el banderín DELETED\n");
		else
		System.out.println("No soporta el banderín DELETED\n");
		if (banderasSoportadas.contains(Flags.Flag.DRAFT))
		System.out.println("Soporta el banderín DRAFT\n");
		else
		System.out.println("No soporta el banderín DRAFT\n");
		if (banderasSoportadas.contains(Flags.Flag.FLAGGED))
		System.out.println("Soporta el banderín FLAGGED\n");
		else
		System.out.println("No soporta el banderín FLAGGED\n");
		if (banderasSoportadas.contains(Flags.Flag.RECENT))
		System.out.println("Soporta el banderín RECENT\n");
		else
		System.out.println("No soporta el banderín RECENT\n");
		if (banderasSoportadas.contains(Flags.Flag.SEEN))
		System.out.println("Soporta el banderín SEEN\n");
		else
		System.out.println("No soporta el banderín SEEN\n");
		if (banderasSoportadas.contains(Flags.Flag.USER))
		System.out.println("Soporta el banderín USER\n");
		else
		System.out.println("No soporta el banderín USER\n");
		// Obtener el mensaje número 1 de todos los mensajes
		
		Message mensaje = folder.getMessage(1);
		// Establecer el banderín FLAGGED a true
		mensaje.setFlag(Flags.Flag.FLAGGED,true);
		// Comprobar si el banderín FLAGGED de este mensaje ha sido
		// establecido
		if (mensaje.isSet(Flags.Flag.FLAGGED))
		System.out.println ("El banderín FLAGGED ha sido activado");
		// Cerrar el Folder y el Store
		folder.close(true);
		store.close();
		} catch (MessagingException me) {
		System.err.println(me.toString());
		} catch (IndexOutOfBoundsException ioe) {
		System.err.println("No podemos acceder al mensaje número 1"
		+ ioe.toString());
		}
		
	}
	
}
