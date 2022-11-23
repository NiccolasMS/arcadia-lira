package Lira.Arcadia.controle.utils;

import org.hibernate.annotations.common.reflection.java.JavaXMember;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.Properties;

public class Email{
    public static void main(String[] args) {
        String usuario = "bruno.calmeida@bandtec.com.br";
        String senha = "Pazesossego123";

        Properties props = new Properties();

        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port","587");
       // props.setProperty("mail.smtp.starttls.enable", "true");
        //props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");


        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(usuario,senha);
                }
        });

        session.getProperties().put("mail.smtp.starttls.enable", "true");
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.office365.com");

        session.setDebug(true);

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));

            Address[] toUser = InternetAddress.parse("bruno.calmeida@bandtec.com.br");
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("thiago.cordeiro@bandtec.com.br"));
            message.setSubject("Stephanini demissão");
            message.setText("Agradecemos pelo seus serviços, está demitido");
            Transport.send(message);
        }catch (Exception e)
        {
            System.out.println(e);
        }



    }
}