package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotBlank(message = "Заголовок вакансии обязателен")
    @Size(max = 100, message = "Заголовок не может быть длиннее 100 символов")
    private String title;

    @NotBlank(message = "Описание вакансии обязательно")
    @Size(max = 2000, message = "Описание не может быть длиннее 2000 символов")
    private String description;

    @Positive(message = "Зарплата должна быть положительной")
    private BigDecimal salary;

    @NotBlank(message = "Тип занятости обязателен")
    @Pattern(regexp = "INTERNSHIP|PART_TIME|FULL_TIME", message = "Тип должен быть INTERNSHIP, PART_TIME или FULL_TIME")
    private String type;

    private String location;

    private LocalDateTime postedAt = LocalDateTime.now();

    private LocalDate deadline;

    private boolean isActive = true;
}