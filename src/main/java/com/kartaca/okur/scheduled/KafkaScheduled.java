package com.kartaca.okur.scheduled;

import com.kartaca.okur.modal.Log;
import com.kartaca.okur.producer.LogsCreateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@EnableAsync
@Service
@RequiredArgsConstructor
public class KafkaScheduled {

    private final LogsCreateProducer logsCreateProducer;


    @Async
    @Scheduled(fixedRate = 3_600_000)
    public void readAllLog() {
        List<Log> logs = readLogs();
        logsCreateProducer.produce(logs);
        clearLogFiles();


    }

    public List<Log> readLogs() {
        try {
            Path path = Paths.get("x.log/spring.log");
            return Files.lines(path).map(s -> {
                String[] str = s.split(": ");
                String[] values = str[str.length - 1].split(",");
                return new Log(values[0], Long.valueOf(values[1]), Long.valueOf(values[2]));

            }).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }
    public void clearLogFiles() {
        try {
             new File("x.log/spring.log").delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
