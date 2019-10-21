package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

public class DbConfig extends AbstractDBConfig {

    @Override
    public void init(AppContext context) {

        String pool = "java:comp/env/jdbc/db_pool"; //ver context.xml

        environment("development").jndi(pool);
        environment("production").jndi(pool);
    }
}
