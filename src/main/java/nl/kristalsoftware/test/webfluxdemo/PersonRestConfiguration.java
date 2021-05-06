package nl.kristalsoftware.test.webfluxdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PersonRestConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(PersonService personService) {
        return route()
                .GET("persons/{name}", (sr) -> ServerResponse.ok().body(personService.getPerson(sr.pathVariable("name")), Person.class))
                .build();
    }
}
