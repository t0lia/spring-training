package spring_training.lab5_aop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring_training.lab5_aop.model.ApuBar;
import spring_training.lab5_aop.model.Bar;
import spring_training.lab5_aop.model.CustomOut;
import spring_training.lab5_aop.model.Person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static spring_training.lab5_aop.model.CustomOut.getOutResult;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
class ApplicationTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Person person;

    @BeforeEach
    void setUp() {
        bar.sellSquishee(person).getName();
    }

    @Test
    void testBeforeAdvice() {
        assertTrue("Before advice is not good enough...", getOutResult().contains("Hello"));
        assertTrue("Before advice is not good enough...", getOutResult().contains("How are you doing?"));
    }

    @Test
    void testAfterAdvice() {
        assertTrue("After advice is not good enough...", getOutResult().contains("Good Bye!"));
    }

    @Test
    void testAfterReturningAdvice() {
        assertTrue("Customer is broken", getOutResult().contains("Good Enough?"));
    }

    @Test
    void testAroundAdvice() {
        assertTrue("Around advice is not good enough...", getOutResult().contains("Hi!"));
        assertTrue("Around advice is not good enough...", getOutResult().contains("See you!"));
    }

    @Test
    void testAllAdvices() {
        assertFalse(bar instanceof ApuBar);
    }

    @AfterEach
    void tearDown() {
        CustomOut.clear();
    }
}