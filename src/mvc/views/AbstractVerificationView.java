package mvc.views;

import mvc.controller.Controller;
import mvc.model.events.IVerificationListener;

public abstract class AbstractVerificationView extends AbstractView implements IVerificationListener {

    public AbstractVerificationView(Controller controller) {
        super(controller);
    }

}
