package spring_training.lab6_jdbc;

import spring_training.lab6_jdbc.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryDao {

    void save(Country country);

    void update(Country country);

    List<Country> getAllCountries();

    Optional<Country> getCountryByName(String name);

    List<Country> getStartWith(String prefix);

    void clear();

}
