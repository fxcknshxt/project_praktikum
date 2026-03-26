package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @NotBlank(message = "Название компании/отдела обязательно")
    @Size(max = 100)
    private String companyName;

    private String department;

    private String contactPerson;

    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Некорректный формат телефона")
    private String phone;

    @Size(max = 500)
    private String about;
}