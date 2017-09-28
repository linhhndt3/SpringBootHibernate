package edu.hanoi.jazz.springjazz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan({"edu.hanoi.controller","edu.hanoi.jazz.dao.impl"})
@ImportResource("classpath:config.xml")
public class SpringJazzApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJazzApplication.class, args);
		ctx.start();
	}
}
