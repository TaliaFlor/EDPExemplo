package edp.event;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {
    private final String json;

    public UserEvent(Object source, String json) {
        super(source);
        this.json = json;
    }

    public String getJson() {
        return json;
    }
}
