package com.example.oil;

import com.example.oil.service.ExcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OilApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OilApplication.class, args);

		try {
			context.getBean(ExcelService.class).start(null);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
