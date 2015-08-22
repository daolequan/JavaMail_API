import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendingEmailWithAttachmentsUsingGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String to = "dao_le_quan@hotmail.com";
		String user="daolequan@gmail.com";
		String password="kidd4ol3qu4nnu(3";
		// Properties file
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// Session
		Session session = Session.getInstance(props, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {	
				return new PasswordAuthentication(user, password);
			}
		});
		// Message
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(to));
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject("Test");

			// BodyPart
			BodyPart msgBody = new MimeBodyPart(); // day la phan text cua email
			msgBody.setText("This email consist of attachment file");
			
			BodyPart msgAttach = new MimeBodyPart(); // day la phan attachment
			String fileName = "C:\\Upload\\amanda_seyfried.jpg"; 
			DataSource source = new FileDataSource(fileName); source.
			msgAttach.setDataHandler(new DataHandler(source));
			msgAttach.setFileName(fileName);
			
			Multipart multipart = new MimeMultipart(); // day la body hoan chinh
			multipart.addBodyPart(msgBody);
			multipart.addBodyPart(msgAttach);
			msg.setContent(multipart);
			
			Transport.send(msg);
			System.out.println("The email with attachment file was sent successfully!");
			
			
		} catch (MessagingException e) {
			System.out.println("The mail was failed to sending");
			e.printStackTrace();
		}
		
		
		
	}

}
