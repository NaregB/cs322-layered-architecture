package am.config;

import org.h2.tools.Server;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@EntityScan(basePackages = {"am.cs322.model, am.banking.model"})
public class SharedApplicationConfig {}
