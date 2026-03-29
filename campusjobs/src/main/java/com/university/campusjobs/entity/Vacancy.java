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
    @Size(max = 100)
    private String title;

    @NotBlank(message = "Описание вакансии обязательно")
    @Size(max = 2000)
    private String description;

    @Positive(message = "Зарплата должна быть положительной")
    private BigDecimal salary;

    @NotBlank(message = "Тип занятости обязателен")
    @Pattern(regexp = "INTERNSHIP|PART_TIME|FULL_TIME")
    private String type;

    private String location;

    private LocalDateTime postedAt = LocalDateTime.now();

    private LocalDate deadline;

    @Column(name = "is_active")
    private boolean isActive = true;

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }
}