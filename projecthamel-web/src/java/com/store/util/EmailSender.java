/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.util;

import com.store.entities.Item;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author rosharma
 */
public class EmailSender {

    String hostname;
    String userName;
    String password;

    public EmailSender() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream(
                "com/store/properties/server.properties"));
        this.hostname = prop.getProperty("email_host");
        this.userName = prop.getProperty("email_username");
        this.password = prop.getProperty("email_password");
    }

    public void sendEmail(String email, List<Item> items, int cartTotal) throws IOException,
            NoSuchProviderException, MessagingException {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", this.hostname);
            Session session = Session.getDefaultInstance(prop, null);
            Transport bus = session.getTransport("smtp");
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("store@projecthamel.com"));

            msg.setRecipients(javax.mail.Message.RecipientType.TO, email);
            msg.setSubject("Testing Plain text - Tej");
            msg.setSentDate(new Date());

            MimeBodyPart mbphtml = new MimeBodyPart();

            Multipart mp = new MimeMultipart("alternative");

            String myText = "Thanks for shopping at project Thamel.\n";

            myText += "Your order info is: \n";
            myText += "***********************************************\n";
            double totalPrice = 0;
            for (Item i : items) {
                myText += "Name: " + i.getName() + " Price: $" + i.getPrice() + "\n";
                totalPrice += totalPrice + i.getPrice();
            }
            myText += "Total Price: $" + totalPrice + "\n\n";
            myText += "Store Administrator";
            mbphtml.setContent(myText, "text/plain");

            mp.addBodyPart(mbphtml);
            msg.setContent(mp);
            bus.connect(hostname, this.userName, password);
            Transport.send(msg);
            bus.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
