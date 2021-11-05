package de.novatec.asyncapi.service;

import de.novatec.streetlight.measured.v1.LightMeasuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LightPeriodCommandConsumer {
    private final Logger logger = LoggerFactory.getLogger(LightPeriodCommandConsumer.class);

    @KafkaListener(topics = "lightperiod-command-v1", groupId = "group_id")
    public void consume(LightMeasuredEvent event) {
        logger.info(String.format("Consumed message: %s", event.toString()));
    }
}
