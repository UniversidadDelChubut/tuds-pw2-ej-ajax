package app.controllers;

import app.models.ContactoForm;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class ContactoController extends AppController {

    public void index() {
        view("motivos", ContactoForm.getMotivos());
    }

    @POST
    public void enviar() throws InterruptedException {
        Thread.sleep(1L * 1000);
        
       try{
           ContactoForm.validar(params1st());
        } catch(IllegalArgumentException ex) {
            respond(ex.getMessage()).status(400);
            return;
        }

        respond("OK");
    }

    public void gracias() {
    }

}
