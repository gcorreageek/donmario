package gui;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;
  
/** 
 * 
 * @author Randy Amaya 
 * DISE�ADO POR: 
 * RANDY FRANCISCO AMAYA GUILLEN 
 * EMAIL: <A href="mailto:randyamaya@amayasystems.com">randyamaya@amayasystems.com</A> 
 * MOVIL: 9565-4366 
 * 
 */
  
public class RecibirCorreos2
{ 
    String usuario_google="jonatant16"; 
    String password_google="2012doomsday"; 
    Message[] mensajes=new Message[0]; 
    Folder folder_raiz = null; 
    Folder folder=null; 
  
   public RecibirCorreos2() 
   { 
        Properties prop = new Properties(); 
        prop.setProperty("mail.pop3.starttls.enable", "false"); 
        prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        prop.setProperty("mail.pop3.socketFactory.fallback", "false"); 
        prop.setProperty("mail.pop3.port", "995"); 
        prop.setProperty("mail.pop3.socketFactory.port", "995"); 
        Session sesion = Session.getInstance(prop); 
        try
        { 
            Store store = sesion.getStore("pop3"); 
            store.connect("pop.gmail.com", usuario_google+"@gmail.com", password_google); 
            folder_raiz = store.getDefaultFolder(); 
            folder=folder_raiz.getFolder("INBOX"); 
            folder.open(Folder.READ_WRITE); 
            mensajes =folder.getMessages(); 
            JOptionPane.showMessageDialog(null,"Mensajes Encontrados "+mensajes.length); 
            for (int i = 0; i < mensajes.length; i++) 
            { 
                String msg[]=new String[3]; 
                msg[0]=mensajes[i].getFrom()[0].toString(); 
                msg[1]=mensajes[i].getSubject(); 
                msg[2]=mensajes[i].getSentDate()+""; 
                System.out.println("De: "+msg[0]); 
                System.out.println("Asunto: "+msg[1]); 
                System.out.println("Fecha: "+msg[2]); 
  
                System.out.println("CONTENIDO:\n"+analizar_Correo(mensajes[i],"")); 
  
                System.out.println("Adjunto: "+mensajes[i].ATTACHMENT.toString()); 
                System.out.println("No se: "+mensajes[i].INLINE); 
                System.out.println("====================================================================="); 
            } 
            folder.close(false); 
            store.close(); 
        } 
        catch (Exception e) 
        { 
            JOptionPane.showMessageDialog(null,"No Conecto\nVerifique Su Conexion a Internet"); 
            e.printStackTrace(); 
        } 
    } 
  
   public String analizar_Correo(Part unaParte,String area) 
    { 
        try
        { 
            if (unaParte.isMimeType("multipart/*")) 
            { 
                Multipart multi; 
                multi = (Multipart) unaParte.getContent(); 
  
                if(multi!=null) 
                { 
                    BodyPart par=null; 
                    int pas=-1; 
                    try
                    { 
                        pas=multi.getCount(); 
                    }catch(Exception w) 
                    { 
                        System.out.println("Error "); 
                    } 
  
                    if(pas==0) 
                    { 
                    } 
                    else
                    { 
                        for (int j = 0; j < pas; j++) 
                        { 
                            par= multi.getBodyPart(j); 
                        } 
                        area=analizar_Correo(par,area); 
                    } 
                } 
            } 
            else
            { 
                if(unaParte.isMimeType("text/*")) 
                { 
                    /*System.out.println("Texto " + unaParte.getContentType()); 
                    System.out.println(unaParte.getContent()); 
                    System.out.println("---------------------------------");*/ 
  
                    area+="\nTexto " + unaParte.getContentType(); 
                    try
                    { 
                        area+="\n"+unaParte.getContent(); 
                    }catch(Exception ew) 
                    { 
                        System.out.print("Error "); 
                    } 
  
                    area+="\n"+"---------------------------------"; 
                } 
                else
                { 
                    if (unaParte.isMimeType("image/*")) 
                    { 
                       /* System.out.println("Imagen " + unaParte.getContentType()); 
                        System.out.println("Fichero=" + unaParte.getFileName()); 
                        System.out.println("---------------------------------");*/ 
                        area+="\n"+"Imagen " + unaParte.getContentType(); 
                        area+="\n"+"Fichero=" + unaParte.getFileName(); 
                        area+="\n---------------------------------"; 
  
                    } 
                    else
                    { 
                        //System.out.println("Recibido " + unaParte.getContentType()); 
                        area+="\n"+"Recibido " + unaParte.getContentType(); 
                        area+="\n---------------------------------"; 
                        //System.out.println("---------------------------------"); 
                    } 
                } 
            } 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        return area; 
    } 
  
    public static void main(String args[]) 
    { 
        new RecibirCorreos2(); 
    } 
}

