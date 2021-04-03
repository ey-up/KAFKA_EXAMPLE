package com.kartaca.okur.listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartaca.okur.repository.LogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogsCreateListener {
    private final LogsRepository logsRepository;

    @KafkaListener(topics = "${spring.kafka.topics.create-logs.name}", containerFactory = "kafkaCreateLogsListenerFactory")
    public void listenLogCreateMessage(@Payload String message) {
        try {
            logsRepository.saveAll(new ObjectMapper().readValue(message, new TypeReference<>() {
            }));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
