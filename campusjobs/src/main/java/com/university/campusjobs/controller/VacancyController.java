package com.university.campusjobs.controller;

import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.service.VacancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@Tag(name = "Vacancies", description = "Работа с вакансиями и стажировками")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Operation(summary = "Получить все активные вакансии")
    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        return ResponseEntity.ok(vacancyService.getAllActiveVacancies());
    }

    @Operation(summary = "Поиск вакансий по ключевому слову")
    @GetMapping("/search")
    public ResponseEntity<List<Vacancy>> searchVacancies(@RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(vacancyService.searchVacancies(keyword));
    }
}