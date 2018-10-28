package spring_training.lab4.model.contact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VasiaContact extends AbstractContact {

    public VasiaContact(@Value("Vasia") String name, @Value("+7 921 444 11 88") String phone) {
        super(name, phone);
    }
}
