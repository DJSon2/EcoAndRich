package com.dongin.ecoandrich1.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(title = "EcoAndRich SERVICE API 명세서",
					 description = "Spring Data Jpa에서 진행하는 서비스 API 명세서",
					 version = "v1"))
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi chatOpenApi() {
		String [] paths = { "/hr/**", "/api/**", "/job/**" };
		
		return GroupedOpenApi.builder()
							 .group("주문 서비스 API v1")
							 .pathsToMatch(paths)
							 .build();
	}
}










