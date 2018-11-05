package spring_training.lab8_tx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Country {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private String codeName;

    public Country() {
    }

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public Country(long id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public String getCodeName() {
        return codeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Country setCodeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(codeName, country.codeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, codeName);
    }

    @Override
    public String toString() {
        return String.format(
                "Country[id=%d, name='%s', codeName='%s']",
                id, name, codeName);
    }
}
