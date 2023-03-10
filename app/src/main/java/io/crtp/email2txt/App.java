/*
 * This Java source file was generated by the Gradle 'init' task.
 * https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 */
package io.crtp.email2txt;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Transport;
import javax.mail.Session;

public class App {
    public String getGreeting() {
        return "Email2Txt dev";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        final String username = "cf2141@tgndomains.com";
        final String password = "......";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "mail.tgndomains.com");
        prop.put("mail.smtp.port", "25");
        //prop.put("mail.smtp.port", "110");
        prop.put("mail.smtp.auth", "true");
        //prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cf2141@tgndomains.com"));
            //message.setRecipients( Message.RecipientType.TO, InternetAddress.parse("greeneh@gmail.com") );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse("4434332699@txt.att.net") );
            message.setSubject("incremental dev");
            message.setText("Next to Txt");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("email message sent");
    }
}
