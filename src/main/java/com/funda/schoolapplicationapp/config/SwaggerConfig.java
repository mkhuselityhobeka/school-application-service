package com.funda.schoolapplicationapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket LearnerApis() {
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis(RequestHandlerSelectors.basePackage("com.funda.schoolapplicationapp.controller"))
				   .build()
				   .apiInfo(apiMetadata());
	}

	
	@SuppressWarnings("deprecation")
	public ApiInfo apiMetadata() {
		
		ApiInfo apiInfo = new ApiInfo("Spring boot REST API", "Leraner Application System", "1.0",
				    "Used by Students", "Mkhuseli Tyhobeka, email:mkhuselityhobeka@gmail.com", "", "");
		
		return apiInfo;
	}
}
