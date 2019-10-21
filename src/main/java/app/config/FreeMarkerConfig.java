package app.config;

public class FreeMarkerConfig extends org.javalite.activeweb.freemarker.AbstractFreeMarkerConfig {

    @Override
    public void init() {
        //https://www.stuartgunter.org/posts/freemarker-default-number-formatting/
        getConfiguration().setNumberFormat("0.##");
    }
}
