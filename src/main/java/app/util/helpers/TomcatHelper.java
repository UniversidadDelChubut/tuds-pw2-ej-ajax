package app.util.helpers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TomcatHelper {

    public static Object getVariable(String nombre_variable) throws NamingException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");

        return envCtx.lookup(nombre_variable);
    }
}
