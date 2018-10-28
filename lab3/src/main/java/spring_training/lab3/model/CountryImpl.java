package spring_training.lab3.model;

public class CountryImpl  implements Country{
    private String name;
    private String codeName;

    public CountryImpl(String name, String codeName) {
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
