package com.kartaca.okur.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class KafkaScheduled {

    @Async
    @Scheduled(fixedRate = 600_000)
    public void readAllLog() {
        System.out.println("eyo");
        //LOGLARI OKU
        // KAFKA PRODUCE ET

    }


}
