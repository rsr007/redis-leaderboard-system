package com.ravidev.service;

import com.ravidev.dto.ScoreUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    KafkaTemplate <String, ScoreUpdateRequest> kafkaTemplate;
    private static final String TOPIC = "score-updates";

    public void sendUpdateRequest(ScoreUpdateRequest request){
        kafkaTemplate.send(TOPIC, request.getUserid(), request);
    }
}
