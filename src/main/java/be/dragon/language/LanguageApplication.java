package be.dragon.language;

import be.dragon.language.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"be.dragon.language"})
public class LanguageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanguageApplication.class, args);
	}
}
