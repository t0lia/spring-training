package spring_training.lab4.model;

import spring_training.lab4.model.contact.Contact;

import java.util.List;


public class PersonImpl implements Person {

    private String name;
    private int age;
    private float height;
    private boolean programmer;

    private Country country;
    private List<Contact> contacts;

    public PersonImpl(Country country, List<Contact> contacts) {
        this.country = country;
        this.contacts = contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Country getCountry() {
        return country;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", country=" + country +
                ", contacts=" + contacts +
                '}';
    }
}
