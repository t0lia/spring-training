package spring_training.lab7_jpa;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_training.lab7_jpa.model.Country;
import spring_training.lab7_jpa.model.CountryDao;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    private static Country rus = new Country("Russia", "RUS");
    private static Country usa = new Country("United States of America", "USA");
    private static Country gb = new Country("Great Britain", "GB");
    private static Country fra = new Country("France", "FRA");

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        CountryDao service = context.getBean(CountryDao.class);
        service.save(rus);
        service.save(usa);
        service.save(gb);
        service.save(fra);
        service.getAllCountries().forEach(log::info);

    }

}
