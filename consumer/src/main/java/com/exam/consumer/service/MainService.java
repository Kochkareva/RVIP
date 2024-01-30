package com.exam.consumer.service;

import com.exam.consumer.model.MainModel;
import com.exam.consumer.repository.MainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    private final MainRepository repository;

    public MainService(MainRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "topic", groupId = "MyGroup")
    public void consume(String message){
        logger.info(String.format("Message received -> %s", message));

        MainModel model = new MainModel();
        int number = Integer.parseInt(message);
        model.setNumber(number);
        model.setIs_Even((number & 2) == 0);
        repository.save(model);
    }

    public List<MainModel> readAll(){
        return  repository.findAll();
    }
}
