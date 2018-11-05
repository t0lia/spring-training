package spring_training.lab8_tx.model;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    void save(Country country);



    List<Country> getAllCountriesMandatory();

    List<Country> getAllCountriesRequired();

    void clear();
}
