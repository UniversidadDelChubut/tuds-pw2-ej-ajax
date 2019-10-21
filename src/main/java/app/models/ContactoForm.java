package app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.javalite.common.Collections;
import org.javalite.common.Util;

/**
 * Un modelo de dominio simple, para validar un request.
 * @author equipo
 */
public class ContactoForm {
    
    public static List getMotivos() {
        List motivos = new ArrayList();
        motivos.add(Collections.map("id", 1, "value", "Agradecimiento"));
        motivos.add(Collections.map("id", 2, "value", "Consulta"));
        motivos.add(Collections.map("id", 3, "value", "Reclamo"));
        
        return motivos;
    }
    
    public static void validar(Map params) {
        if (Util.blank(params.get("nombre"))) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        if (Util.blank(params.get("email"))) {
            throw new IllegalArgumentException("El email no es válido.");
        }
        if (Util.blank(params.get("motivo"))) {
            throw new IllegalArgumentException("El motivo no es válido.");
        }
        if (Util.blank(params.get("comentario"))) {
            throw new IllegalArgumentException("El comentario no es válido.");
        }
    }
    
}
