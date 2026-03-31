package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurityConsumerAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringSecurityConsumerAppApplication.class, args);

		String apiUrl = "http://localhost:8080/msg";

		HttpHeaders headers = new HttpHeaders();

		headers.setBasicAuth("roshni","roshni@123");

		HttpEntity<String> reqEntity = new HttpEntity<>(headers);

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> resEntity = rt.exchange(apiUrl, HttpMethod.GET, reqEntity,String.class);

		System.out.println(resEntity.getBody());
	}

}
