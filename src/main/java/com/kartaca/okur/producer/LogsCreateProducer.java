package com.kartaca.okur.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartaca.okur.modal.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogsCreateProducer {
    @Value("${spring.kafka.topics.create-logs.name}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(List<Log> logs){
        try {
            kafkaTemplate.send(topicName,new ObjectMapper().writeValueAsString(logs));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
