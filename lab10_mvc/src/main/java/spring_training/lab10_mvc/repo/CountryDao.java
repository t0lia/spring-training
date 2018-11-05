package spring_training.lab10_mvc.repo;

import spring_training.lab10_mvc.model.Country;

import java.util.List;

public interface CountryDao {
    void save(Country country);

    List<Country> getAll();
}
