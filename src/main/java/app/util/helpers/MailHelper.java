package app.util.helpers;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.javalite.activeweb.AppContext;

public class MailHelper {

    private final String USUARIO_CORREO;
    private final String PASSWORD_CORREO;

    public MailHelper(AppContext ac) {
        USUARIO_CORREO = (String)ac.get("usuario_correo");
        PASSWORD_CORREO = (String)ac.get("password_correo");
    }
    

    public void mandarMail(String para, String asunto, String mensaje) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(USUARIO_CORREO, PASSWORD_CORREO));
        email.setSSLOnConnect(true);
        email.setFrom(USUARIO_CORREO);
        email.setSubject(asunto);
        email.setHtmlMsg(mensaje);
        email.addTo(para);
        email.send();
    }

    
}
