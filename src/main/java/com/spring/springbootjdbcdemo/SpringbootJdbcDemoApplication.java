package com.spring.springbootjdbcdemo;

import com.spring.springbootjdbcdemo.model.Alien;
import com.spring.springbootjdbcdemo.repository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringbootJdbcDemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);

		alien1.setId(111);
		alien1.setName("Gowsi");
		alien1.setTech("Java");

		System.out.println(alien1);

		AlienRepository alienRepository = context.getBean(AlienRepository.class);

		alienRepository.save(alien1);
		System.out.println(alienRepository.getAll());
	}

}
