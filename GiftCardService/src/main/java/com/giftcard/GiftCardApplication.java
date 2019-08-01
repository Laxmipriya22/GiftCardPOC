package com.giftcard;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GiftCardApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public DozerBeanMapper getDozerBeanMapper() {
		return new DozerBeanMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(GiftCardApplication.class, args);
	}
}
