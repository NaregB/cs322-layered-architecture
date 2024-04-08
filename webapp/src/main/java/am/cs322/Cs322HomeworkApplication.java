package am.cs322;

import am.config.SharedApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Collections;

@SpringBootApplication(scanBasePackages = "am.cs322")
@Import(SharedApplicationConfig.class)
public class Cs322HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Cs322HomeworkApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        app.run(args);
    }
}