package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @Min(value = 1, message = "Рейтинг от 1 до 5")
    @Max(value = 5, message = "Рейтинг от 1 до 5")
    private Integer rating;

    @Size(max = 500, message = "Комментарий не может быть длиннее 500 символов")
    private String comment;

    @NotBlank(message = "Тип отзыва обязателен")
    private String type; // STUDENT_TO_EMPLOYER или EMPLOYER_TO_STUDENT
}