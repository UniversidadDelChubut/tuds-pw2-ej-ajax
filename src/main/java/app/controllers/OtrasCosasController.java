package app.controllers;

import javax.naming.NamingException;
import org.apache.commons.mail.EmailException;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class OtrasCosasController extends AppController {

    public void index() {

    }

    @POST
    public void mandarMail() {
        //validar parametros...
        String para = param("su_email");
        String asunto = "Correo de prueba!";
        String mensaje = merge("/otras_cosas/ejemplo_mail", params1st());

        try {
            MailHelper.mandarMail(para, asunto, mensaje);
        } catch (NamingException | EmailException ex) {
            logError(ex.getMessage(), ex);
            flash("error", "No se pudo enviar el correo: " + ex.getMessage());
            render("index");
            return;
        }

        flash("mensaje", "El mail se envió correctamente");
        redirect();
    }

}
