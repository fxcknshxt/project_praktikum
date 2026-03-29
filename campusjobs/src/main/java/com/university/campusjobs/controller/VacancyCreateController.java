package com.university.campusjobs.controller;

import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.service.VacancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacancies")
@Tag(name = "Vacancy Creation", description = "Создание вакансий")
public class VacancyCreateController {

    private final VacancyService vacancyService;

    public VacancyCreateController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Operation(summary = "Создать новую вакансию")
    @PostMapping("/create")
    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        Vacancy savedVacancy = vacancyService.createVacancy(vacancy);
        return ResponseEntity.ok(savedVacancy);
    }
}