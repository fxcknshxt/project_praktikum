package com.university.campusjobs.repository;

import com.university.campusjobs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}