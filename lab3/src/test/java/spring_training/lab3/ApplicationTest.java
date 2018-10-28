package spring_training.lab3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_training.lab3.model.Person;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ApplicationTest {

    @Test
    void name() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
        Person person = context.getBean(Person.class);

        assertEquals("Ivan", person.getName());
        assertEquals(22, person.getAge());
        assertEquals(192.1F, person.getHeight(), 0.01F);
        assertTrue(person.isProgrammer());

        assertEquals("RUS", person.getCountry().getCodeName());
        assertEquals("Russia", person.getCountry().getName());

        assertEquals(Arrays.asList("Petia: +7 921 222 33 22", "Vasia: +7 921 444 11 88"), person.getContacts());


    }

}