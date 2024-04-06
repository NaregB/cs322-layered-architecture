package soa322_hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"soa322_hw"})
public class CS322SOA {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CS322SOA.class);
            System.setProperty("server.port", "8081");
        app.run(args);
    }
}
