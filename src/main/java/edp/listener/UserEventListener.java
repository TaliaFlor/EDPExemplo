package edp.listener;

import edp.event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserEventListener implements ApplicationListener<UserEvent> {
    private static final Logger logger = Logger.getLogger(UserEventListener.class.getName());

    @Override
    public void onApplicationEvent(UserEvent event) {
        logger.info("EVENTO CONSUMIDO - " + event.getJson());
    }

}
