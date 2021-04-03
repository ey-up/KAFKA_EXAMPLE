package com.kartaca.okur.configuration.kafka.consumer.logsCreate;
import com.kartaca.okur.configuration.kafka.consumer.KafkaListenerConfiguration;
import com.kartaca.okur.configuration.kafka.consumer.KafkaListenerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@RequiredArgsConstructor
public class LogsCreateKafkaListenerConfiguration {
    private final KafkaListenerProperties logsCreateKafkaListenerProperties;
    private final KafkaListenerConfiguration kafkaListenerConfiguration;

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaCreateLogsListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaListenerConfiguration.getConsumerFactory(logsCreateKafkaListenerProperties));
        factory.setConcurrency(logsCreateKafkaListenerProperties.getConcurrency());
        factory.setMissingTopicsFatal(false);
        return factory;
    }
}
