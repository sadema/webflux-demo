package nl.kristalsoftware.test.webfluxdemo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveCrudRepository<Person,String> {

    Mono<Person> findByName(String name);

}
