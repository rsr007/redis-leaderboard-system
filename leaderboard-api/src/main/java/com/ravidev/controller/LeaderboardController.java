package com.ravidev.controller;

import com.ravidev.config.KafkaProducerConfig;
import com.ravidev.dto.ScoreUpdateRequest;
import com.ravidev.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final KafkaProducerService kafkaProducerService;

    //constructor injection is preferred, so it is recommended practice
    //instead of using field injection @Autowired
    public LeaderboardController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/update-score")
    public ResponseEntity<String> updateScore(@RequestBody ScoreUpdateRequest request){
        kafkaProducerService.sendUpdateRequest(request);
        return ResponseEntity.ok("score update request sent to kafka");
    }
}
