package pro.sisit.javacource.unit7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Unit7Application {

	public static void main(String[] args) {
		SpringApplication.run(Unit7Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void createJokesTable(){
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS jokes (joke text)");

	}

}
