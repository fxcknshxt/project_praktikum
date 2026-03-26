package com.university.campusjobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @NotBlank(message = "Название резюме обязательно")
    @Size(max = 100, message = "Название резюме не может быть длиннее 100 символов")
    private String title;

    private String fileUrl;

    private LocalDateTime uploadedAt = LocalDateTime.now();
}