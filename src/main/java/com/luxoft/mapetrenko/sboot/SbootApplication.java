package com.luxoft.mapetrenko.sboot;

import com.luxoft.mapetrenko.sboot.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {SbootApplication.class, JpaConfig.class}, args);
	}
}
