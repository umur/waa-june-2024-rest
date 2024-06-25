package com.miu.waa;

import com.miu.waa.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WaaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course waa = new Course(1L, "WAA", "cs-545");
		Course wap = new Course(2L, "WAP", "cs-445");

	}
}
