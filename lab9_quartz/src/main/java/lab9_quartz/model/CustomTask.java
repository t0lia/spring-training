package lab9_quartz.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CustomTask {

    private static final Logger log = LogManager.getLogger(CustomTask.class);


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0/3 * * ? NOV TUE")
    public void reportCurrentTime() {
        log.info("Custom task:  {}", dateFormat.format(new Date()));
    }
}
