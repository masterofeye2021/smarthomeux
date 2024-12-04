package de.smarthome.smartux;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:application.properties")
@EnableAsync
public class SmartuxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmartuxApplication.class, args);
	}

}
