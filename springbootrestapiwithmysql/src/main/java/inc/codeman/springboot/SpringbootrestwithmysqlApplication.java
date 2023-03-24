package inc.codeman.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication


@OpenAPIDefinition(info=@Info(title = "Spring Boot RESTFul Web Service Documentation",description = "Spring Boot REST API Documentation",version = "v1.0",contact = @Contact (name="Codeman",email="codemanrkg@gmail.com",url="https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/"),license=@License(name="Apache 2.0",url="https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/")),
externalDocs = @ExternalDocumentation(description = "Spring Boot Documentation",url="https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-documentation.html"))
public class SpringbootrestwithmysqlApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestwithmysqlApplication.class, args);
	}

}
