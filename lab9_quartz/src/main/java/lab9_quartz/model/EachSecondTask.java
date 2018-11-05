package lab9_quartz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EachSecondTask {

    private static final Logger log = LogManager.getLogger(EachSecondTask.class);


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void reportCurrentTime() {
        log.info("Each second task: {}", dateFormat.format(new Date()));
    }
}
