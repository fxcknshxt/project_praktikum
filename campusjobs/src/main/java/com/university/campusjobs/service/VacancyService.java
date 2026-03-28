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

    public List<Vacancy> getVacanciesWithFilters(String keyword, String type, Long categoryId) {
        List<Vacancy> vacancies = vacancyRepository.findByIsActiveTrue();

        if (keyword != null && !keyword.trim().isEmpty()) {
            vacancies = vacancies.stream()
                    .filter(v -> v.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                            v.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                    .toList();
        }

        if (type != null && !type.trim().isEmpty()) {
            vacancies = vacancies.stream()
                    .filter(v -> v.getType().equals(type))
                    .toList();
        }

        if (categoryId != null) {
            vacancies = vacancies.stream()
                    .filter(v -> v.getCategory() != null && v.getCategory().getId().equals(categoryId))
                    .toList();
        }

        return vacancies;
    }

}