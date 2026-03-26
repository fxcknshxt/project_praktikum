package com.university.campusjobs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String hello() {
        return "Привет! Backend работает. Campus Jobs API готов к разработке.";
    }

    @GetMapping("/status")
    public String status() {
        return "Статус: Сервер запущен | Сущности созданы | " + java.time.LocalDateTime.now();
    }
}