package spring_training.lab5_aop;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring_training.lab5_aop.model.Bar;
import spring_training.lab5_aop.model.CustomerBrokenException;
import spring_training.lab5_aop.model.Person;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static spring_training.lab5_aop.model.CustomOut.clear;
import static spring_training.lab5_aop.model.CustomOut.getOutResult;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
public class ExceptionTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Person person;

    @BeforeEach
    void setUp() {
        person.setBroken(true);
    }

    @Test
    @DisplayName("Customer is broken")
    void testAfterThrowingAdvice() {

        assertThrows(
                CustomerBrokenException.class,
                () -> bar.sellSquishee(person));

        assertTrue(getOutResult().contains("Hmmm...\n"));
    }

    @AfterEach
    void tearDown() {
        clear();
    }
}
