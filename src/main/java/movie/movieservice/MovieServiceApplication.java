package movie.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"movie.api", "movie.movieservice"})
public class MovieServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
