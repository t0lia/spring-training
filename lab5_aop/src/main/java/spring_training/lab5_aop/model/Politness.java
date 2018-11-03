package spring_training.lab5_aop.model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import static spring_training.lab5_aop.model.CustomOut.execute;

@Aspect
@Component
public class Politness {

    @Pointcut("@annotation(Polite)")
    private void pointcut() {
    }

    @Before("pointcut() && args(person)")
    public void sayHello(Person person) {
        execute(out -> out.printf("Hello %s. How are you doing?%n", person.getName()));
    }

    @AfterReturning(pointcut = "pointcut()", returning = "retVal", argNames = "retVal")
    public void askOpinion(Drink retVal) {
        execute(out -> out.printf("Is %s Good Enough?%n", retVal.getName()));
    }

    @AfterThrowing("pointcut()")
    public void sayYouAreNotAllowed() {
        execute(out -> out.println("Hmmm..."));
    }

    @After("pointcut()")
    public void sayGoodBye() {
        execute(out -> out.println("Good Bye!"));
    }

    @Around("pointcut()")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        execute(out -> out.println("Hi!"));
        Object retVal = pjp.proceed();
        execute(out -> out.println("See you!"));
        return retVal;
    }

}
