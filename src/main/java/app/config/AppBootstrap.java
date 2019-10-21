package app.config;

import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.javalite.activeweb.Configuration;

public class AppBootstrap extends Bootstrap {

    @Override
    public void init(AppContext ac) {
        Configuration.setUseDefaultLayoutForErrors(false);
    }

}
