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
		System.out.println( "Ha de enviar dos par�metros\n" +
		"java ManejoBanderas usuario clave");
		//System.exit(1);
		}
		// Obtener el usuario y la clave recibidos como par�metros
		String usuario = "jonatant16@gmail.com";
		String clave = "2012doomsday";
		// Obtener las propiedades del sistema
		String imapHost = "imap.gmail.com";
		Properties props = System.getProperties();
		// Obtener una sesi�n con las propiedades anteriormente definidas
		Session sesion = Session.getDefaultInstance(props,null);
		// Capturar las excepciones
		try {
		// Crear un Store indicando el protocolo de acceso y conectarse a �l
		Store store = sesion.getStore("imap");
		store.connect(imapHost,usuario,clave);
		// Crear un Folder y abrir la carpeta INBOX en modo
		// LECTURA/ESCRITURA
		Folder folder = store.getFolder("INBOX");
		// Si se abriese en modo de s�lo lectura no se podr�an marcar los
		// mensajes y por tanto parecer� que no se soporta ning�n bander�n
		folder.open(Folder.READ_WRITE);
		// Obtener las banderas soportadas y mostramos cu�les son
		Flags banderasSoportadas = folder.getPermanentFlags();
		if (banderasSoportadas.contains(Flags.Flag.ANSWERED))
		System.out.println("Soporta el bander�n ANSWERED\n");
		else
		System.out.println("No soporta el bander�n ANSWERED\n");
		if (banderasSoportadas.contains(Flags.Flag.DELETED))
		System.out.println("Soporta el bander�n DELETED\n");
		else
		System.out.println("No soporta el bander�n DELETED\n");
		if (banderasSoportadas.contains(Flags.Flag.DRAFT))
		System.out.println("Soporta el bander�n DRAFT\n");
		else
		System.out.println("No soporta el bander�n DRAFT\n");
		if (banderasSoportadas.contains(Flags.Flag.FLAGGED))
		System.out.println("Soporta el bander�n FLAGGED\n");
		else
		System.out.println("No soporta el bander�n FLAGGED\n");
		if (banderasSoportadas.contains(Flags.Flag.RECENT))
		System.out.println("Soporta el bander�n RECENT\n");
		else
		System.out.println("No soporta el bander�n RECENT\n");
		if (banderasSoportadas.contains(Flags.Flag.SEEN))
		System.out.println("Soporta el bander�n SEEN\n");
		else
		System.out.println("No soporta el bander�n SEEN\n");
		if (banderasSoportadas.contains(Flags.Flag.USER))
		System.out.println("Soporta el bander�n USER\n");
		else
		System.out.println("No soporta el bander�n USER\n");
		// Obtener el mensaje n�mero 1 de todos los mensajes
		
		Message mensaje = folder.getMessage(1);
		// Establecer el bander�n FLAGGED a true
		mensaje.setFlag(Flags.Flag.FLAGGED,true);
		// Comprobar si el bander�n FLAGGED de este mensaje ha sido
		// establecido
		if (mensaje.isSet(Flags.Flag.FLAGGED))
		System.out.println ("El bander�n FLAGGED ha sido activado");
		// Cerrar el Folder y el Store
		folder.close(true);
		store.close();
		} catch (MessagingException me) {
		System.err.println(me.toString());
		} catch (IndexOutOfBoundsException ioe) {
		System.err.println("No podemos acceder al mensaje n�mero 1"
		+ ioe.toString());
		}
		
	}
	
}
