import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendingEmailUsingGmail {

	public static void main(String[] args) {
		// 1. Properties file
		Properties prop = new Properties();		
		prop.put("mail.smtp.auth", "true");
		
		final String user = "daolequan";
		final String password = "kidd4ol3qu4nnu(3";
		// 2. Session object
		Session session = Session.getInstance(prop);
		// 3. Message object 
		Message message = new MimeMessage(session);
		try {
			
			message.setSubject("Test");
			message.setText("This is a mail that sent using my proram! If you received it,mean that i was successful. ");			
			message.setFrom(new InternetAddress("daolequan@gmail.com", "daolequan"));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("dao_le_quan@hotmail.com"));
		// 4. Transport object for sending	
			
			Transport trans = session.getTransport("smtps");
			trans.connect("smtp.gmail.com",465,user, password);
			trans.sendMessage(message, message.getAllRecipients());
			System.out.println("Well done");
			
		} catch (MessagingException | UnsupportedEncodingException e) {
			
			System.out.println("You failed!\nYou are f***k noob!");
			System.out.println(e);
			
		}
		

	}

}
