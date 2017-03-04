package kr.co.mash_up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {PersonalPredilectionsBackendApplication.class, Jsr310JpaConverters.class})
public class PersonalPredilectionsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalPredilectionsBackendApplication.class, args);
		System.out.println("Boot Run!!");
	}
}
