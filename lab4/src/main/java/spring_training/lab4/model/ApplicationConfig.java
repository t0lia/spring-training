package spring_training.lab4.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring_training.lab4.model.contact.Contact;

import java.util.List;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Bean
    Person person(Country country, List<Contact> contacts) {
        PersonImpl person = new PersonImpl(country, contacts);
        person.setAge(22);
        person.setHeight(192.1f);
        person.setName("Ivan");
        person.setProgrammer(true);
        return person;
    }
}
