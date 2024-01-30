package com.exam.publisher.controller;

import com.exam.publisher.dto.MainDto;
import com.exam.publisher.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendNumber() {
        return ResponseEntity.ok("Number sent: " + mainService.sendNumber());
    }

    @GetMapping("/read")
    public List<MainDto> readAll() {
        return mainService.getData();
    }
}
