package com.example.oil;

import com.example.oil.service.ParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OilApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OilApplication.class, args);

		try {
			context.getBean(ParserService.class).start();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
