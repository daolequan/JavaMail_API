import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class ReceivingGmail {

	public static void receiveEmail(String pop3Host, String storeType,
			final String user, final String password) {
		// create properties file
		Properties properties = new Properties();
		properties.put("email.store.protocol", "imap");
		
		// create 1 Session object
		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(user, password);
			}

		};
		Session session = Session.getDefaultInstance(properties, auth);
		
		//
		try {
			Store emailStore = session.getStore("imaps");
			emailStore.connect("imap.gmail.com", "daolequan@gmail.com", password);
			
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			System.out.println("Retrieved your email! Wait");
			
			Message[] messages = emailFolder.getMessages();
			for(Message msg: messages) {
				System.out.println("------------------------------------");
				System.out.println("Subject: "+msg.getSubject());
				System.out.println("From: "+msg.getFrom().toString());
				System.out.println("Text: "+msg.getContent().toString()); 
			}
			
			
			emailFolder.close(false);
			emailStore.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void main(String[] args) {
		String host="smtp.gmail.com";
		String mailStoreType="pop3";
		final String username="daolequan@gmail.com" ;
		final String password="******";
		
		receiveEmail(host, mailStoreType, username, password);
	}

}
