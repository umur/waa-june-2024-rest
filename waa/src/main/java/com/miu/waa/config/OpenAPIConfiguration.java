package com.miu.waa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Darkhan");
        myContact.setEmail("daratechn@gmail.com");

        Info info = new Info()
                .title("WAA Assignment #1")
                .version("1.0")
                .description("This API exposes endpoints to manage courses and students")
                .contact(myContact);
        return new OpenAPI().info(info).servers(List.of(server));

    }
}
