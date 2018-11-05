package lab9_quartz;

import lab9_quartz.model.ApplicationConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ApplicationConfig.class);
        log.info("Application started");
    }
}
