package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrackingCoronavirusCovid19Application {

	public static void main(String[] args) {
		SpringApplication.run(TrackingCoronavirusCovid19Application.class, args);
	}

}
