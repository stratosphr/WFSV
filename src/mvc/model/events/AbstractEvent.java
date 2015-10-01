package mvc.model.events;

import java.util.EventObject;

public abstract class AbstractEvent<T> extends EventObject {

    private final T data;

    public AbstractEvent(Object source, T data) {
        super(source);
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
