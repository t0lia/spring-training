package spring_training.lab8_tx;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.IllegalTransactionStateException;
import spring_training.lab8_tx.model.Country;
import spring_training.lab8_tx.model.CountryService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HibernateConfig.class)
class ApplicationTest {

    private List<Country> persistedCountries;

    private Country rus = new Country("Russia", "RUS");
    private Country usa = new Country("United States of America", "USA");
    private Country gb = new Country("Great Britain", "GB");
    private Country fra = new Country("France", "FRA");

    @Autowired
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        persistedCountries = Stream.of(rus, usa, gb, fra)
                .peek(countryService::save)
                .collect(Collectors.toList());
    }

    @Test
    void testGetAllMandatory() {
        assertThrows(
                IllegalTransactionStateException.class,
                () -> countryService.getAllCountriesMandatory());
    }

    @Test
    void testGetAllRequired() {
        List<Country> allCountries = countryService.getAllCountriesRequired();
        assertEquals(allCountries, persistedCountries);
    }

    @AfterEach
    void tearDown() {
        countryService.clear();
    }
}
