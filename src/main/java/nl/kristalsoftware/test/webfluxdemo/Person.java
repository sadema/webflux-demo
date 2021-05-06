package nl.kristalsoftware.test.webfluxdemo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Document
public class Person {

    @Id
    private String id;

    private String name;

    public static Person of(String name) {
        return new Person(null, name);
    }

}
