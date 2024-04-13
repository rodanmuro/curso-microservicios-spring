package com.example.gatewayapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	public WebClient.Builder loadBalancerWebClient(){
		return WebClient.builder();
	}

}
