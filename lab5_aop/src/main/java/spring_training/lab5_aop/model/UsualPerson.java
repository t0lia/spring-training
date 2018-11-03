package spring_training.lab5_aop.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsualPerson implements Person {
    private int id;

    private String name;


    private int age;
    private float height;
    private boolean programmer;

    @Value("false")
    private boolean broken;

    @Override
    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public String getName() {
        return null;
    }
}