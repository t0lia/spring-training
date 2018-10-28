package spring_training.lab4;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_training.lab4.model.ApplicationConfig;
import spring_training.lab4.model.Person;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    void test() {
          ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
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