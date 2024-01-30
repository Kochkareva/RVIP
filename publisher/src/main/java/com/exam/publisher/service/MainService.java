package com.exam.publisher.service;

import com.exam.publisher.dto.MainDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainService.class);
    private final KafkaTemplate<String, String> template;

    public MainService(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public int sendNumber(){
        Random random = new Random();
        // Generate a random number between 0 and 100
        int randomNumber = random.nextInt(101);
        template.send("topic", "" + randomNumber);
        logger.info("Sending number: {}", randomNumber);
        return randomNumber;
    }

    public List<MainDto> getData(){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());
        List<MainDto> mainDtos = null;
        ResponseEntity<String> response = restTemplate.exchange(
                "http://consumer:8081/consumer/read", HttpMethod.GET, entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                mainDtos = objectMapper.readValue(responseBody, ArrayList.class);
            } catch (JsonProcessingException e) {
                logger.info("Не удалось десериализовать тело запроса в объект");
            }
        } else {
            logger.info("Ошибка получения объекта");
        }
        return mainDtos;
    }
}
