package spring_training.lab10_mvc.repo;

import org.springframework.stereotype.Component;
import spring_training.lab10_mvc.model.Country;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDaoImpl implements CountryDao {

    private List<Country> countries = new ArrayList<Country>();

    @Override
    public void save(Country country) {
        countries.add(country);
    }

    @Override
    public List<Country> getAll() {
        return countries;
    }
}
