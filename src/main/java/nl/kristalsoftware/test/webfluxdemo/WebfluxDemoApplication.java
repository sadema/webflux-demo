package nl.kristalsoftware.test.webfluxdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class WebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxDemoApplication.class, args);
    }

}

@Component
@RequiredArgsConstructor
class DataInitializer {

    private final PersonRepository personRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        Flux<Person> persons = Flux
                .just("Piet", "Klaas", "Jan", "Thea", "Sandra")
                .map(name -> Person.of(name))
                .flatMap(it -> personRepository.save(it))
                .log();

        persons.subscribe();
    }

}
