package com.university.campusjobs.controller;

import com.university.campusjobs.entity.Application;
import com.university.campusjobs.entity.CoverLetter;
import com.university.campusjobs.entity.Student;
import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@Tag(name = "Applications", description = "Подача и управление заявками на вакансии")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Подать заявку на вакансию")
    @PostMapping
    public ResponseEntity<Application> createApplication(
            @RequestParam Long studentId,
            @RequestParam Long vacancyId,
            @RequestBody CoverLetter coverLetter) {

        Application application = applicationService.createApplication(studentId, vacancyId, coverLetter);
        return ResponseEntity.ok(application);
    }

    @Operation(summary = "Получить заявки студента")
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getStudentApplications(@PathVariable Long studentId) {
        return ResponseEntity.ok(applicationService.getStudentApplications(studentId));
    }
}