package com.university.campusjobs.service;

import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.repository.EmployerRepository;
import com.university.campusjobs.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final EmployerRepository employerRepository;

    public VacancyService(VacancyRepository vacancyRepository, EmployerRepository employerRepository) {
        this.vacancyRepository = vacancyRepository;
        this.employerRepository = employerRepository;
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

    public Vacancy createVacancy(Vacancy vacancy) {
        if (vacancy.getEmployer() == null) {
            employerRepository.findAll().stream().findFirst().ifPresent(vacancy::setEmployer);
        }
        vacancy.setPostedAt(LocalDateTime.now());
        vacancy.setIsActive(true);
        return vacancyRepository.save(vacancy);
    }

    public Optional<Vacancy> getVacancyById(Long id) {
        return vacancyRepository.findById(id);
    }
}