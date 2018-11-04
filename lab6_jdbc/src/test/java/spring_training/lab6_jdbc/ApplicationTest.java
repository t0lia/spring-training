package spring_training.lab6_jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring_training.lab6_jdbc.model.Country;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
class ApplicationTest {

    private static Logger log = LogManager.getLogger(ApplicationTest.class);


    private List<Country> persistedCountries;

    private Country rus = new Country("Russia", "RUS");
    private Country usa = new Country("United States of America", "USA");
    private Country gb = new Country("Great Britain", "GB");
    private Country fra = new Country("France", "FRA");

    @Autowired
    private CountryDao countryDao;

    @BeforeEach
    void setUp() {
        persistedCountries = Stream.of(rus, usa, gb, fra)
                .peek(countryDao::save)
                .collect(Collectors.toList());
    }

    @Test
    void testGetAll() {
        List<Country> allCountries = countryDao.getAllCountries();
        assertEquals(allCountries, persistedCountries);
    }

    @Test
    void testStartWith() {
        List<Country> startWithR = countryDao.getStartWith("R");
        assertEquals(startWithR, Collections.singletonList(rus));
        List<Country> startWithUnited = countryDao.getStartWith("United");
        assertEquals(startWithUnited, Collections.singletonList(usa));
    }

    @Test
    void testFindByName() {
        Optional<Country> actual = countryDao.getCountryByName("France");
        actual
                .map(x -> {
                    assertEquals(fra, x);
                    return x;
                })
                .orElseThrow(() -> new AssertionError("Can't find"));
    }

    @Test
    void testUpdate() {
        countryDao.getCountryByName("Russia")
                .map(country -> country.setName("USSR"))
                .ifPresent(countryDao::update);

        countryDao.getCountryByName("USSR").orElseThrow(() -> new AssertionError("can't find updated value"));
    }

    @AfterEach
    void tearDown() {
        countryDao.clear();
    }
}