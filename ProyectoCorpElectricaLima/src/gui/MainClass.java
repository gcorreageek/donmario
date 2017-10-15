package gui;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;

public class MainClass {

  public static void main(String[] args) throws Exception {

   // URLName server = new URLName("imaps://corporacionelectricalima@gmail.com:@imap.gmail.com/INBOX");
//imaps://:@imap.gmail.com/INBOX  imaps://username%40gmail.com@imap.gmail.com/INBOX
    //Session session = Session.getDefaultInstance(new Properties(), new MailAuthenticator());

    Store store;
    Folder folder;
    /*if (folder == null) {
      System.out.println("Folder " + server.getFile() + " not found.");
      System.exit(1);
    }
    folder.open(Folder.READ_ONLY);*/
    /*********************************************************************************************************/
    Properties props = System.getProperties();
	props.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.imap.starttls.enable", "true");
	props.put("mail.imap.auth", "true");
	props.put("mail.imap.socketFactory.fallback", "false");
	props.put("mail.imap.port", "993");
	props.put("mail.imap.socketFactory.port", "993");
	props.put("mail.imap.disabletop", "true");
	Session sesion = Session.getDefaultInstance(props,null);
	
	try{
		
	
	store = sesion.getStore("imap");
	store.connect("imap.gmail.com","electro.cornejo02@gmail.com","marioalberto2011");
	
	folder = store.getFolder("INBOX");
	folder.open(Folder.READ_ONLY);
			//mensajes=folder.getMessages();
    /************************************************************************************************************/
    // Get the messages from the server
    Message[] messages = folder.getMessages();
    for (int i = 0; i < messages.length; i++) {
      // Get the headers
      /*System.out.println("From: " + InternetAddress.toString(messages[i].getFrom()));
      System.out.println("Reply-to: " + InternetAddress.toString(messages[i].getReplyTo()));
      System.out.println("To: " + InternetAddress.toString(messages[i].getRecipients(Message.RecipientType.TO)));
      System.out.println("Cc: " + InternetAddress.toString(messages[i].getRecipients(Message.RecipientType.CC)));
      System.out.println("Bcc: " + InternetAddress.toString(messages[i].getRecipients(Message.RecipientType.BCC)));
      System.out.println("Subject: " + messages[i].getSubject());

      System.out.println("Sent: " + messages[i].getSentDate());
      System.out.println("Received: " + messages[i].getReceivedDate());*/

      if (messages[i].isSet(Flags.Flag.DELETED)) {
        System.out.println("Deleted");
      }
      if (messages[i].isSet(Flags.Flag.ANSWERED)) {
        System.out.println("Answered");
      }
      if (messages[i].isSet(Flags.Flag.DRAFT)) {
        System.out.println("Draft");
      }
      if (messages[i].isSet(Flags.Flag.FLAGGED)) {
        System.out.println("Marked");
      }
      if (messages[i].isSet(Flags.Flag.RECENT)) {
        System.out.println("Recent");
      }
      if (messages[i].isSet(Flags.Flag.SEEN)) {
        //System.out.println("Read");
      }
      if (messages[i].isSet(Flags.Flag.USER)) {
        // We don't know what the user flags might be in advance
        // so they're returned as an array of strings
        String[] userFlags = messages[i].getFlags().getUserFlags();
        for (int j = 0; j < userFlags.length; j++) {
          System.out.println("User flag: " + userFlags[j]);
        }
      }
    }
	}catch (MessagingException me) {
		JOptionPane.showMessageDialog(null, "Error, intentalo otra vez-ME");
		
    } catch (SecurityException se){
		JOptionPane.showMessageDialog(null, "Error, intentalo otra vez-SE");
		
    }
    //folder.close(false);
  }
}

class MailAuthenticator extends Authenticator {

  public MailAuthenticator() {
  }

  public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("electro.cornejo02@gmail.com","marioalberto2011");
  }
}
