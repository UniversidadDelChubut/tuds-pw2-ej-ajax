package app.config;

import app.util.helpers.TomcatHelper;
import javax.naming.NamingException;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.javalite.activeweb.Configuration;

public class AppBootstrap extends Bootstrap {

    @Override
    public void init(AppContext ac) {
        Configuration.setUseDefaultLayoutForErrors(false);
        setearEntornoTomcat(ac);
    }

    private void setearEntornoTomcat(AppContext ac) {
        try {
            ac.set("recaptcha_public_key", (String) TomcatHelper.getVariable("recaptcha_public_key"));
            ac.set("recaptcha_private_key", (String) TomcatHelper.getVariable("recaptcha_private_key"));
            ac.set("usuario_correo", (String) TomcatHelper.getVariable("usuario_correo"));
            ac.set("password_correo", (String) TomcatHelper.getVariable("password_correo"));
            ac.set("jwt_private_key", (String) TomcatHelper.getVariable("jwt_private_key"));
        } catch (NamingException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
