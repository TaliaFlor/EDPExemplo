package edp;

import edp.model.User;
import edp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EdpExemplo implements CommandLineRunner {

    private final UserService service;

    @Autowired
    public EdpExemplo(UserService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdpExemplo.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) {
        User user = new User(1203457690L, "user@gmail.com", "Thunderbird", "P@ssW0rd");
        user = service.updateEmail(user, "thunderbird@gmail.com");
        System.out.println(user);
    }

}
