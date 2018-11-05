package spring_training.lab8_tx.model;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Country> getAllCountriesMandatory() {
        return countryDao.getAllCountries();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Country> getAllCountriesRequired() {
        return countryDao.getAllCountries();
    }

    @Override
    public void clear() {
        countryDao.clear();
    }
}
