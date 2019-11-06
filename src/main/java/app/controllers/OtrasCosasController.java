package app.controllers;

import app.util.helpers.MailHelper;
import app.util.helpers.TomcatHelper;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.Map;
import javax.naming.NamingException;
import org.apache.commons.lang3.time.DateUtils;
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

    @POST
    public void pruebaGenerarToken() throws NamingException {
        String mail = param("su_email");

        String token = generarJWT(mail);
        view("token", token);
    }

    @POST
    public void pruebaVerificarToken() throws NamingException {
        try {
            DecodedJWT token_verificado = verificarJWT(param("token"));
            view("token_verificado", token_verificado);

        } catch (Exception ex) {
            logError(ex.getMessage(), ex);
            view("error", "El token no pudo validarse: " + ex.getMessage());
        }
    }
    
    // https://github.com/auth0/java-jwt
    private String generarJWT(String mail) {
        try {
            String secret = (String) TomcatHelper.getVariable("jwt_private_key");
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("mutual")
                    .withSubject(mail)
                    .withExpiresAt(DateUtils.addMinutes(new Date(), 2)) // expira en 2 minutos
                    .sign(algorithm);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo generar el token de prueba.", ex);
        }
    }
    
    // https://github.com/auth0/java-jwt
    private DecodedJWT verificarJWT(String token) throws NamingException {
        String secret = (String) TomcatHelper.getVariable("jwt_private_key");
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("mutual")
                .acceptLeeway(2 * 60) // 2 minutos de "diferencia"
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

}
