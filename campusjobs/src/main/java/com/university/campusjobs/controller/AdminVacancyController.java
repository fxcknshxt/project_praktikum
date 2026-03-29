package com.university.campusjobs.controller;

import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.service.VacancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/vacancies")
@Tag(name = "Admin Vacancies", description = "Управление вакансиями (для работодателей и админов)")
public class AdminVacancyController {

    private final VacancyService vacancyService;

    public AdminVacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Operation(summary = "Создать новую вакансию")
    @PostMapping
    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {

        Vacancy saved = vacancyService.createVacancy(vacancy);
        return ResponseEntity.ok(saved);
    }
}