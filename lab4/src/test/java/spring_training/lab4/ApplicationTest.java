package spring_training.lab4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring_training.lab4.model.ApplicationConfig;
import spring_training.lab4.model.Person;
import spring_training.lab4.model.contact.AbstractContact;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
class ApplicationTest {

    @Autowired
    private Person person;

    @Test
    void test() {

        assertEquals("Ivan", person.getName());
        assertEquals(22, person.getAge());
        assertEquals(192.1F, person.getHeight(), 0.01F);
        assertTrue(person.isProgrammer());

        assertEquals("RUS", person.getCountry().getCodeName());
        assertEquals("Russia", person.getCountry().getName());

        AbstractContact expectedVasia = new AbstractContact("Vasia", "+7 921 444 11 88") {
        };

        AbstractContact expectedPetia = new AbstractContact("Petia", "+7 921 222 33 22") {
        };
        assertEquals(Arrays.asList(expectedPetia, expectedVasia), person.getContacts());

    }
}