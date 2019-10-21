package app.controllers;

import org.javalite.activeweb.AppController;

public class HomeController extends AppController {

    public void index() {

    }

    public void seccion1() throws InterruptedException {
        devolverAjax();
    }

    public void seccion2() throws InterruptedException {
        devolverAjax();
    }

    public void seccion3() throws InterruptedException {
        devolverAjax();
    }

    public void seccion4() throws InterruptedException {
        devolverAjax();
    }

    private void devolverAjax() throws InterruptedException {
        Thread.sleep(1L * 1000);
        render().noLayout();
    }

}
