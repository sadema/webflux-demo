package nl.kristalsoftware.test.webfluxdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Flux<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Mono<Person> getPerson(String name) {
        return personRepository.findByName(name);
    }

//    public Mono<Void> deletePerson(String name) {
//        Mono<Person> mPerson = getPerson(name);
//        mPerson.subscribe();
//                .then(it -> personRepository.delete(it))
//    }
}
