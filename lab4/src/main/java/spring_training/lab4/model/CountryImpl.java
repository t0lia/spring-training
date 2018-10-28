package spring_training.lab4.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CountryImpl implements Country {
    private String name;
    private String codeName;

    public CountryImpl(@Value("${country.name}") String name, @Value("${country.codeName}") String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public String getCodeName() {
        return codeName;
    }
}
