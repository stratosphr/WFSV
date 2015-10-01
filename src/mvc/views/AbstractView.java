package mvc.views;

import mvc.controller.Controller;

public abstract class AbstractView {

    private Controller controller;

    public AbstractView(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public abstract void display();

    public abstract void close();

}
