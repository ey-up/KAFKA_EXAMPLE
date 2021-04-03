package com.kartaca.okur.configuration.kafka.consumer;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@EnableKafka
@Configuration
public class KafkaListenerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;


    public DefaultKafkaConsumerFactory<String, String> getConsumerFactory(KafkaListenerProperties kafkaListenerProperties) {
        return getDefaultKafkaConsumerFactory(kafkaListenerProperties, bootstrapServers);
    }

    private DefaultKafkaConsumerFactory<String, String> getDefaultKafkaConsumerFactory(KafkaListenerProperties kafkaListenerProperties, String servers) {
        Map<String, Object> consumerConfigs = new HashMap<>();
        consumerConfigs.put(BOOTSTRAP_SERVERS_CONFIG, servers);
        consumerConfigs.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfigs.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfigs.put(GROUP_ID_CONFIG, kafkaListenerProperties.getGroupId());
        consumerConfigs.put(AUTO_OFFSET_RESET_CONFIG, kafkaListenerProperties.getOffsetReset());
        consumerConfigs.put(ENABLE_AUTO_COMMIT_CONFIG, kafkaListenerProperties.isAutoCommit());
        consumerConfigs.put(SESSION_TIMEOUT_MS_CONFIG, kafkaListenerProperties.getSessionTimeout());
        consumerConfigs.put(MAX_POLL_RECORDS_CONFIG, kafkaListenerProperties.getMaxPoll());
        return new DefaultKafkaConsumerFactory<>(consumerConfigs, new StringDeserializer(), new StringDeserializer());
    }
}