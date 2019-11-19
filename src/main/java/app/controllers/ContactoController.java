package app.controllers;

import app.models.ContactoForm;
import ar.mppfiles.utils.validation.simple.ParamValidationException;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class ContactoController extends AppController {

    public void index() {
        view("motivos", ContactoForm.getMotivos());
    }

    @POST
    public void enviar() throws InterruptedException, ParamValidationException {
        Thread.sleep(1L * 1000);
        
       
        ContactoForm cf = new ContactoForm().fromMap(params1st());
        cf.validate();      //ver ParamValidationFilter
      
        //todo OK
        respond("OK");
    }

    public void gracias() {
    }

}
