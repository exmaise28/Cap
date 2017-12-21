package lab;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages="repository")
@EntityScan(basePackages= {"service", "entity"})

public class ApplicationConfig {
	 
}

