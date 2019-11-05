package app.controllers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

class MailHelper {

    public static void mandarMail(String para, String asunto, String mensaje) throws EmailException, NamingException {
        String usuario_correo = getTomcatVariable("usuario_correo");
        String password_correo = getTomcatVariable("password_correo");

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

    private static String getTomcatVariable(String nombre_variable) throws NamingException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");

        String var = (String) envCtx.lookup(nombre_variable);
        return var;
    }
}
