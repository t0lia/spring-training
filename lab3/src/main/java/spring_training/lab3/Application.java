package spring_training.lab3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_training.lab3.model.Person;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
