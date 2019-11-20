package app.models;

import ar.mppfiles.utils.validation.simple.ParamValidator;
import java.util.ArrayList;
import java.util.List;
import org.javalite.common.Collections;

/**
 * Un modelo de dominio simple, para validar un request.
 *
 * @author equipo
 */
public class ContactoForm extends ParamValidator {

    public static List getMotivos() {
        List motivos = new ArrayList();
        motivos.add(Collections.map("id", 1, "value", "Agradecimiento"));
        motivos.add(Collections.map("id", 2, "value", "Consulta"));
        motivos.add(Collections.map("id", 3, "value", "Reclamo"));

        return motivos;
    }

    @Override
    protected void doValidate() throws Exception {
        this
                .con("nombre").requerido()
                .conMensaje("falta el nombre")
                .letrasConEspacios().minLargo(3)
                .conMensaje("el nombre es incorrecto")
                
                .con("email").requerido().texto()
                .con("motivo").requerido().entero().min(1).max(3)
                .con("comentario").requerido().texto().minLargo(10)
                .check();
    }
}
