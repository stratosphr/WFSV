package mvc.model.events;

import mvc.model.parameters.Parameters;

public class ParametersChangedEvent extends AbstractEvent<Parameters>{

    public ParametersChangedEvent(Object source, Parameters data) {
        super(source, data);
    }

}
