package mvc.model.events;

import mvc.model.implementations.EImplementation;

public class ImplementationChangedEvent extends AbstractEvent<EImplementation>{

    public ImplementationChangedEvent(Object source, EImplementation implementation) {
        super(source, implementation);
    }

}
