package spring_training.lab3.model;

import java.util.List;

public interface Person {

    String getName();

    int getAge();

    float getHeight();

    boolean isProgrammer();

    Country getCountry();

    List<String> getContacts();
}
