package spring_training.lab4.model;

import java.util.List;

public interface Person {

    String getName();

    int getAge();

    float getHeight();

    boolean isProgrammer();

    Country getCountry();

    List<String> getContacts();
}
