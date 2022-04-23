package com.training.service.productandservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.training.service.productandservice.data.UserResponse;

@SpringBootTest
class ProductandserviceApplicationTests {

	@Test
	void contextLoads() {
		
		String URI = "http://localhost:8080/servicerequest/findUserById?userId=4";
		RestTemplate restTemplate =  new RestTemplate();
		ResponseEntity forEntity = restTemplate.getForEntity(URI,  ResponseEntity.class );
		Object obj = forEntity.getBody();
		System.out.println(obj.getClass());
		
	}

}
