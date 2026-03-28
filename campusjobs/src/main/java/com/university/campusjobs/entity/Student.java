package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
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
    @Size(max = 100)
    private String fullName;

    @NotBlank(message = "Факультет обязателен")
    private String faculty;

    @Min(value = 1)
    @Max(value = 6)
    private Integer course;

    @Column(name = "student_group")
    private String studentGroup;

    @Pattern(regexp = "^\\+?\\d{10,15}$")
    private String phone;

    @Size(max = 500)
    private String about;
}