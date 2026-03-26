package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank(message = "ФИО обязательно")
    @Size(max = 100, message = "ФИО не может быть длиннее 100 символов")
    private String fullName;

    @NotBlank(message = "Факультет обязателен")
    private String faculty;

    @Min(value = 1, message = "Курс должен быть не меньше 1")
    @Max(value = 6, message = "Курс не может быть больше 6")
    private Integer course;

    private String group;

    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Некорректный формат телефона")
    private String phone;

    @Size(max = 500, message = "Описание не может быть длиннее 500 символов")
    private String about;
}