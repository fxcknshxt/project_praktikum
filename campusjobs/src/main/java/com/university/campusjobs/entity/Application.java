package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "vacancy_id", nullable = false)
    private Vacancy vacancy;

    @OneToOne
    @JoinColumn(name = "cover_letter_id")
    private CoverLetter coverLetter;

    @NotBlank(message = "Статус обязателен")
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    private LocalDateTime appliedAt = LocalDateTime.now();
}