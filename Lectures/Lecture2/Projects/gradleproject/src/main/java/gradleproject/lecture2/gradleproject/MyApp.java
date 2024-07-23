package gradleproject.lecture2.gradleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class MyApp {

	@RequestMapping("/health")
	String health() {
		return "Healthy";
	}
	@RequestMapping("/")
	String home() {
		return "Spring Boot Gradle Project is running!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

}
