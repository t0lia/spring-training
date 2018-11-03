package spring_training.lab5_aop.model;

import org.springframework.stereotype.Component;

import static spring_training.lab5_aop.model.CustomOut.execute;

@Component
public final class ApuBar implements Bar {

    @Override
    @Polite
    public Drink sellSquishee(Person person) {
        if (person.isBroken())
            throw new CustomerBrokenException();

        execute(out -> out.println("Here is your squishee."));
        return () -> "Squishee";
    }
}
