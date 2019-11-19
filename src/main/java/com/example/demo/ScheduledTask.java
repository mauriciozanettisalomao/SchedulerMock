package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron ="0/30 * * * * *")
    public void reportCurrentTime() {
        log.info("Data/hora da execução {}", dateFormat.format(new Date()));
        
        try {

            System.out.println("Inicio");

            Process process = Runtime.getRuntime().exec("java -jar JavaArgsExample-0.0.1-SNAPSHOT.jar 123 456 789");

            System.out.println("Fim");

         } catch (Exception ex) {
            ex.printStackTrace();
         }
    }
}