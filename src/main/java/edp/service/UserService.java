package edp.service;

import edp.enums.Event;
import edp.model.User;
import edp.publisher.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserEventPublisher publisher;

    @Autowired
    public UserService(UserEventPublisher publisher) {
        this.publisher = publisher;
    }

    public User updateEmail(User user, String email) {
        user.setEmail(email);
        publisher.publish(user.getId(), Event.CHANGE_EMAIL_CONFIRMATION, email);
        logger.info("EMAIL DO USUÁRIO " + user.getId() + " ATUALIZADO");
        return user;
    }
}
