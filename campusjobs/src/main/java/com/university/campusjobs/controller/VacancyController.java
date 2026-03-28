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

    @Operation(summary = "Получить одну вакансию по ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable Long id) {
        return vacancyService.getVacancyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Получить вакансии с фильтрами")
    @GetMapping("/filtered")
    public ResponseEntity<List<Vacancy>> getFilteredVacancies(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long categoryId) {

        return ResponseEntity.ok(vacancyService.getVacanciesWithFilters(keyword, type, categoryId));
    }

}