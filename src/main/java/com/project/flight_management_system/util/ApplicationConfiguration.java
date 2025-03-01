package com.project.flight_management_system.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Flight Management System").description(
				"The Airport Management System allows airlines, passengers, and staff to manage flights, booking details, luggage, and other airport-related tasks efficiently. "
						+ "This system provides a seamless experience for flight check-in, tracking, and various airport services, both online and offline.")
				.version("1.0").contact(new Contact().name("Qspiders Team").email("airportteam@example.com"))
				.license(new License().name("License").url("#")));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").packagesToScan("com.project.flight_management_system")
				.build();
	}
}

