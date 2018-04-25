import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailBySite {  
 public static boolean sendMsgTOMail(String args,String s,String p,String r) {  
  
 // String host="mail.javatpoint.com";  
  String host="smtp.gmail.com";  
  final String user=s;//change accordingly  
  final String password=p;//change accordingly  
    
 // String to="jain.ankit9@tcs.com";//change accordingly  
 // String to="ankitjain091090@gmail.com";
  String to=r;
   //Get the session object  
   Properties props = new Properties();  
  // props.put("mail.smtp.host",host);  
 //  props.put("mail.smtp.auth", "true");  
   
   props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Check Disk Space & Message send from java code");  
     message.setText(args);  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
     return true;
   
     } catch (MessagingException e) {
    	 System.out.println(e.getMessage()+"------ANKIT");
    	 e.printStackTrace();
    return false;	 
     }  
 }  
}  