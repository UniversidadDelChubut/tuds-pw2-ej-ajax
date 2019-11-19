package app.controllers.filters;

import ar.mppfiles.utils.validation.simple.ParamValidationException;
import org.javalite.activeweb.controller_filters.AppControllerFilter;
import org.javalite.common.Collections;

/**
 * Devuelve un JSON con errores de validación.
 *
 * @author mrpalaciopentucci
 */
public class ParamValidationFilter extends AppControllerFilter {

    @Override
    public void onException(Exception e) {
        if (e.getCause() instanceof ParamValidationException) {
            if (isXhr()) {
                render(
                        "/system/errores_validacion_json",
                        Collections.map("errores", ((ParamValidationException) e.getCause()).getErrores()))
                        .noLayout()
                        .contentType("application/json")
                        .status(400);
            } else {
                render(
                        "/system/errores_validacion",
                        Collections.map("errores", ((ParamValidationException) e.getCause()).getErrores()))
                        .status(400);
            }
        }
    }
}
