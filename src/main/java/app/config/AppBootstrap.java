package app.config;

import javax.naming.Context;
import javax.naming.InitialContext;
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
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            
            ac.set("recaptcha_url", (String) envCtx.lookup("recaptcha_url"));
            ac.set("recaptcha_public_key", (String) envCtx.lookup("recaptcha_public_key"));
            ac.set("recaptcha_private_key", (String) envCtx.lookup("recaptcha_private_key"));
            ac.set("usuario_correo", (String) envCtx.lookup("usuario_correo"));
            ac.set("password_correo", (String) envCtx.lookup("password_correo"));
            ac.set("jwt_private_key", (String) envCtx.lookup("jwt_private_key"));
        } catch (NamingException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
