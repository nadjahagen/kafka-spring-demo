package de.novatec.asyncapi.service;

import de.novatec.streetlight.measured.v1.LightMeasuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "lightmeasured-event-v1";

    @Autowired
    private KafkaTemplate<String, LightMeasuredEvent> kafkaTemplate;

    public void onLightMeasured(LightMeasuredEvent event) {
        logger.info(String.format("Producing message: %s", event.toString()));
        this.kafkaTemplate.send(TOPIC, event.getId(), event);
    }
}
