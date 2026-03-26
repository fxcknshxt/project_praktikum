package com.university.campusjobs.repository;

import com.university.campusjobs.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findByIsActiveTrue();

    List<Vacancy> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}