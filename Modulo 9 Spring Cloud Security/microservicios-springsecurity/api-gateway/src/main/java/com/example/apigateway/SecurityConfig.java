package com.example.apigateway;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
		
		serverHttpSecurity.authorizeExchange(exchanges->exchanges.anyExchange().authenticated())
		.oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()));
		
		serverHttpSecurity.csrf(csrf->csrf.disable());
		
		return serverHttpSecurity.build();
		
	}
	
	
	
	

}
