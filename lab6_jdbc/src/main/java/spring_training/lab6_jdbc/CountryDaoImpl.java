package spring_training.lab6_jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring_training.lab6_jdbc.model.Country;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import static spring_training.lab6_jdbc.Queries.*;

@Repository
public class CountryDaoImpl implements CountryDao {

    private static Logger log = LogManager.getLogger(CountryDaoImpl.class);
    private static String sql = "update mytable set name = ? where id = ?";

    private static RowMapper<Country> customerRowMapper = (rs, rowNum) -> new Country(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("code_name"));

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void setup() {
        jdbcTemplate.execute(DROP_TABLE_SQL);
        jdbcTemplate.execute(CREATE_TABLE_SQL);
    }


    @Override
    public void save(Country country) {
        jdbcTemplate.update(INSERT_SQL, country.getName(), country.getCodeName());

    }

    @Override
    public void update(Country country) {
        jdbcTemplate.update(UPDATE_SQL, country.getName(), country.getCodeName(), country.getId());
    }

    @Override
    public List<Country> getAllCountries() {
        return jdbcTemplate.query(SELECT_SQL, customerRowMapper);
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        return jdbcTemplate.query(SELECT_BY_NAME_SQL, new Object[]{name}, customerRowMapper).stream().findFirst();
    }

    @Override
    public List<Country> getStartWith(String prefix) {
        return jdbcTemplate
                 .query(SELECT_BY_NAME_START_WITH_SQL, new Object[]{prefix + "%"}, customerRowMapper);
    }

    @Override
    public void clear() {
       jdbcTemplate.execute(DELETE_SQL);
    }
}
