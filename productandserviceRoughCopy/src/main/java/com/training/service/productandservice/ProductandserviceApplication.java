package com.training.service.productandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProductandserviceApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(ProductandserviceApplication.class, args);
	}

	
	/*//
	 * public static void main(String[] args) { ConfigurableApplicationContext
	 * context = SpringApplication.run(ProductandserviceApplication.class, args);
	 * 
	 * User user= context.getBean(User.class); System.out.println(user.toString());
	 * 
	 * User user1= context.getBean(User.class);
	 * System.out.println(user1.toString()); }
	 */
	 

}
