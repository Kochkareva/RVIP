package com.exam.consumer.controller;

import com.exam.consumer.model.MainModel;
import com.exam.consumer.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/read")
    public List<MainModel> readAll() {
        return mainService.readAll();
    }
}
