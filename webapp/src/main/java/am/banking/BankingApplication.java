package am.banking;

import am.config.SharedApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Collections;


@SpringBootApplication(scanBasePackages = {"am.banking"})
@Import(SharedApplicationConfig.class)
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BankingApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8087"));
        app.run(args);
    }
}
