import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmailUsingHotmail {

	public static void main(String[] args) {
		final String user = "dao_le_quan@hotmail.com";
		final String password ="***********";
		// Properties file
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		// Session object
		Session session = Session.getInstance(prop);
		
		Message message = new MimeMessage(session);
		try {
			message.setSubject("Test");
			message.setText("This is a mail that sent using my proram! If you received it,mean that i was successful. ");
			message.setFrom(new InternetAddress("dao_le_quan@hotmail.com",
					"daolequan"));
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse("daolequan@gmail.com"));
		
			Transport trans = session.getTransport("smtp");
			trans.connect("smtp.live.com", 587, user, password);
			System.out.println("Well done");
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.out.println("You failed!\nYou are f***k noob!");
			System.out.println(e);

		}

	}

}
