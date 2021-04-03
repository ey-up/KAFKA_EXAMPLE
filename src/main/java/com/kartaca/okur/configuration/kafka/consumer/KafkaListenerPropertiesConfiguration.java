package com.kartaca.okur.configuration.kafka.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaListenerPropertiesConfiguration {

    @Bean
    @ConfigurationProperties("spring.kafka.consumer.logs-create")
    public KafkaListenerProperties logsCreateListenerProperties() {
        return new KafkaListenerProperties();
    }

}
