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


        System.out.println("Inicio da session");

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(usuario,senha);
            }
        });

        System.out.println("Iniciando get properties");

        session.getProperties().put("mail.smtp.starttls.enable", "true");
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.office365.com");

        System.out.println("Iniciando debug");

        session.setDebug(true);

        System.out.println("Debug true iniciando");

        try{
            System.out.println("Instanciando objeto");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));

            Address[] toUser = InternetAddress.parse("bruno.calmeida@bandtec.com.br");
            System.out.println("Criando conteudo da mensagem");
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("brunoo_henriquee_chagas@hotmail.com"));
            message.setSubject("Stephanini demissão");
            message.setText("Agradecemos pelo seus serviços, está demitido");
            System.out.println("Pronto para enviar...");

            Transport tr = session.getTransport("smtp");
            tr.connect(usuario,senha);
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
            //Transport.send(message);
            tr.close();
        }catch (Exception e)
        {
            System.out.println("Deu erro dentro do try");
            System.out.println(e);
        }



    }
}