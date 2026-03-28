package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Текст сопроводительного письма обязателен")
    @Size(min = 5, max = 2000, message = "Сопроводительное письмо должно быть от 5 до 2000 символов")
    private String content;
}