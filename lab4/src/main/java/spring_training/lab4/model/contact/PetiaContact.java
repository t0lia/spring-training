package spring_training.lab4.model.contact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PetiaContact extends AbstractContact {

    public PetiaContact(@Value("Petia") String name, @Value("+7 921 222 33 22") String phone) {
        super(name, phone);
    }
}
