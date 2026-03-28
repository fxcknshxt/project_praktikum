package com.university.campusjobs.service;

import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getAllActiveVacancies() {
        return vacancyRepository.findByIsActiveTrue();
    }

    public List<Vacancy> searchVacancies(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getAllActiveVacancies();
        }
        return vacancyRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    public Optional<Vacancy> getVacancyById(Long id) {
        return vacancyRepository.findById(id);
    }

}