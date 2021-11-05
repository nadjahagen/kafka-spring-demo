package de.novatec.asyncapi.controller;

import de.novatec.asyncapi.service.LightMeasuredEventProducer;
import de.novatec.streetlight.measured.v1.LightMeasuredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final LightMeasuredEventProducer lightMeasuredEventProducer;

    @Autowired
    KafkaController(LightMeasuredEventProducer lightMeasuredEventProducer) {
        this.lightMeasuredEventProducer = lightMeasuredEventProducer;
    }

    @PostMapping(value = "/publish", consumes = "application/json")
    public void sendMessageToKafkaTopic(@RequestBody LightMeasuredEvent event){
        this.lightMeasuredEventProducer.onLightMeasured(event);
    }
}
