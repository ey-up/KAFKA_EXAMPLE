package com.kartaca.okur.scheduled;

import com.kartaca.okur.modal.Log;
import com.kartaca.okur.producer.LogsCreateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.PrintWriter;
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
        if (logs.size() > 0) {
            clearLogFiles();
        }
    }

    public List<Log> readLogs() {
        try {
            File file = new File("x.log/spring.log");
            Path path = Paths.get("x.log/spring.log");
            if (file.exists()) {
                return Files.lines(path).map(s -> {
                    String[] str = s.split(": ");
                    String[] values = str[str.length - 1].split(",");
                    return new Log(values[0], Long.valueOf(values[1]), Long.valueOf(values[2]));
                }).collect(Collectors.toList());
            } else {
                System.out.println("file not found for read");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void clearLogFiles() {
        try {
            File file = new File("x.log/spring.log");
            if (file.exists()) {
                PrintWriter printWriter = new PrintWriter("x.log/spring.log");
                printWriter.write("");
                printWriter.close();
            } else {
                System.out.println("File not found for delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
