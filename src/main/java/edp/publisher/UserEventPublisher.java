package edp.publisher;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edp.enums.Event;
import edp.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserEventPublisher {
    private static final Logger logger = Logger.getLogger(UserEventPublisher.class.getName());

    private final ApplicationEventPublisher publisher;

    @Autowired
    public UserEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(final long userId, final Event event, final String payload) {
        JsonObject object = new JsonObject();
        object.addProperty("userId", userId);
        object.addProperty("event", String.valueOf(event));
        object.addProperty("payload", payload);
        String json = new Gson().toJson(object);

        publisher.publishEvent(new UserEvent(this, json));

        logger.info("EVENTO " + event + " PARA O USUÁRIO " + userId + " COM O PAYLOAD " + payload + " PUBLICADO");
    }

}
