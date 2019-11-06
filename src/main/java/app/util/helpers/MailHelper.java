package app.util.helpers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class MailHelper {

    public static void mandarMail(String para, String asunto, String mensaje) throws EmailException, NamingException {
        String usuario_correo = (String)TomcatHelper.getVariable("usuario_correo");
        String password_correo = (String)TomcatHelper.getVariable("password_correo");

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(usuario_correo, password_correo));
        email.setSSLOnConnect(true);
        email.setFrom(usuario_correo);
        email.setSubject(asunto);
        email.setHtmlMsg(mensaje);
        email.addTo(para);
        email.send();
    }

    
}
