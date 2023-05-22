package inc.codeman.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Spring Boot REST API DOCS",description="User Management RESTFul Application Documentation",version="v1.0",contact=@Contact(email = "codemanrkg@gmail.com",name = "Ranjith Kumar G", url="https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173"),license=@License(name = "Apache 2.0",url = "https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173")),externalDocs = @ExternalDocumentation(url = "https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html",description = "Spring Boot Application Properties"))
public class UserManagementProjectApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementProjectApplication.class, args);
	}

}
