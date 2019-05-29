package com.cognizant.demo.EmployeeDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors
				.basePackage("com.cognizant.demo.EmployeeDemo")).paths(PathSelectors.regex("/.*"))
						.build().apiInfo(apiEndpointsInfo());
	}
	
	private ApiInfo apiEndpointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API-Employee").
				description("Employee Management REST API")
				.contact(new Contact("Dipika Tikate","", "dipika.tikate@cognizant.com"))
				.license("Apache 2.0")
				.version("1.0.0")
				.build();
	}
}
