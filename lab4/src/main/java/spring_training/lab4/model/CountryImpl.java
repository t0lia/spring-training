package spring_training.lab4.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CountryImpl implements Country {
    private String name;
    private String codeName;

    public CountryImpl(@Value("Russia") String name, @Value("RUS") String codeName) {
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
