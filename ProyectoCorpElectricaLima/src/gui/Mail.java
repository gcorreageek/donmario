package gui;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
 
 
 
public class Mail
{
   private String host;
   private String usuario;
   private String password;
   private String puerto;
   private String auth; //boolean
   private String conexionSegura; // boolean
   private String CorreoVictima;
   private String CorreoFalso;
   private String nombreFalso;
   private String mensaje;
   private String asunto;
   public Mail()// constructor sin parametros
   {
   }
// constructor con todos los parametros
   public Mail(String host, String usuario, String password, String puerto, String auth, String conexionSegura, String CorreoVictima, String CorreoFalso, String nombreFalso, String mensaje,String asunto) {
       this.host = host;
       this.usuario = usuario;
       this.password = password;
       this.puerto = puerto;
       this.auth = auth;
       this.conexionSegura = conexionSegura;
       this.CorreoVictima = CorreoVictima;
       this.CorreoFalso = CorreoFalso;
       this.nombreFalso = nombreFalso;
       this.mensaje = mensaje;
       this.asunto = asunto;
 
   }
// constructor sin el nombre falso
   public Mail(String host, String usuario, String password, String puerto, String auth, String conexionSegura, String CorreoVictima, String CorreoFalso, String mensaje,String asunto) {
       this.host = host;
       this.usuario = usuario;
       this.password = password;
       this.puerto = puerto;
       this.auth = auth;
       this.conexionSegura = conexionSegura;
       this.CorreoVictima = CorreoVictima;
       this.CorreoFalso = CorreoFalso;
       this.mensaje = mensaje;
       this.asunto = asunto;
   }
// constructor sin el correo y el nombre falso
   public Mail(String host, String usuario, String password, String puerto, String auth, String conexionSegura, String CorreoVictima, String mensaje,String asunto) {
       this.host = host;
       this.usuario = usuario;
       this.password = password;
       this.puerto = puerto;
       this.auth = auth;
       this.conexionSegura = conexionSegura;
       this.CorreoVictima = CorreoVictima;
       this.mensaje = mensaje;
       this.asunto = asunto;
   }
   public String getAsunto()
   {
       return asunto;
   }
   public void enviarMensaje()
   {
        try
       {
           // Propiedades de la conexión
           Properties props = new Properties();
           props.setProperty("mail.smtp.host",""+ getHost()); // host del server
           props.setProperty("mail.smtp.starttls.enable",""+ getConexionSegura());//seguridad?
           props.setProperty("mail.smtp.port", ""+getPuerto());// puerto en mi caso 25
           props.setProperty("mail.smtp.user",""+ getUsuario());//cualquier cosa
           props.setProperty("mail.smtp.auth", getAuth());//no necesita identifiacion
 
           // Preparamos la sesion
           Session session = Session.getDefaultInstance(props);
           // Construimos el mensaje
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(""+getCorreoFalso()));
 
           message.addRecipient(
               Message.RecipientType.TO,
               new InternetAddress(""+getCorreoVictima()));
           message.setSubject(""+getAsunto());
          // message.setContent(""+getMensaje(),"text/ht ");
                    message.setHeader("text/html","charset=iso-8859-1");
           message.setContent(getMensaje(),"text/html; charset=iso-8859-1");
 
           // Lo enviamos.
           Transport t = session.getTransport("smtp");
         //  t.connect("127.0.0.1", null, null);
          // t.connect("localhost",null,null);
           t.connect(""+getUsuario(),""+getPassword());
        //   for(int i=0;i<5;i++){
           t.sendMessage(message,message.getAllRecipients());//funciona con ciclos
              JOptionPane.showMessageDialog(null, "¡Enviado Correctamente a "+getCorreoVictima()+" !");
        //   }
           // Cierre.
           t.close();
       }
       catch (Exception e)
       {
           e.printStackTrace();
          // e.getMessage();
          JOptionPane.showMessageDialog(null, "Error ... "+ e.getMessage());
       }
   }
 
   public String getCorreoFalso() {
       return CorreoFalso;
   }
 
   public void setCorreoFalso(String CorreoFalso) {
       this.CorreoFalso = CorreoFalso;
   }
 
   public String getCorreoVictima() {
       return CorreoVictima;
   }
 
   public void setCorreoVictima(String CorreoVictima) {
       this.CorreoVictima = CorreoVictima;
   }
 
   public String getAuth() {
       return auth;
   }
 
   public void setAuth(String auth) {
       this.auth = auth;
   }
 
   public String getConexionSegura() {
       return conexionSegura;
   }
 
   public void setConexionSegura(String conexionSegura) {
       this.conexionSegura = conexionSegura;
   }
 
   public String getHost() {
       return host;
   }
 
   public void setHost(String host) {
       this.host = host;
   }
 
   public String getMensaje() {
       return mensaje;
   }
 
   public void setMensaje(String mensaje) {
       this.mensaje = mensaje;
   }
 
   public String getNombreFalso() {
       return nombreFalso;
   }
 
   public void setNombreFalso(String nombreFalso) {
       this.nombreFalso = nombreFalso;
   }
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
 
   public String getPuerto() {
       return puerto;
   }
 
   public void setPuerto(String puerto) {
       this.puerto = puerto;
   }
 
   public String getUsuario() {
       return usuario;
   }
 
   public void setUsuario(String usuario) {
       this.usuario = usuario;
   }
 
 
}