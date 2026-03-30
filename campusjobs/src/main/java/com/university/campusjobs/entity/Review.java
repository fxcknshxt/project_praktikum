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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Max(5)
    private Integer rating;

    @Size(max = 500)
    private String comment;

    private String type; // STUDENT_TO_EMPLOYER

    private LocalDateTime createdAt = LocalDateTime.now();

}