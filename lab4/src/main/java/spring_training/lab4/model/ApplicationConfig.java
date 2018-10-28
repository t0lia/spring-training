package spring_training.lab4.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Bean
    Person person(Country country) {
        PersonImpl person = new PersonImpl(country, Arrays.asList("Petia: +7 921 222 33 22", "Vasia: +7 921 444 11 88"));
        person.setAge(22);
        person.setHeight(192.1f);
        person.setName("Ivan");
        person.setProgrammer(true);
        return person;
    }
}
