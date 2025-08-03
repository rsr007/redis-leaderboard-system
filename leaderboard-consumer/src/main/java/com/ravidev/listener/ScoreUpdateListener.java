package com.ravidev.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ScoreUpdateListener {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String LEADERBOARD_KEY = "leaderboard";

    public void updateUserScore(String userId, int score){
        redisTemplate.opsForZSet().incrementScore(LEADERBOARD_KEY, userId, score);
    }
}
